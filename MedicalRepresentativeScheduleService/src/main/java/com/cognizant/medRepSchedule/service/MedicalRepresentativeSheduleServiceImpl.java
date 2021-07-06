package com.cognizant.medRepSchedule.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medRepSchedule.dao.MedicalRepresntativeRepository;
import com.cognizant.medRepSchedule.exception.InvalidDateException;
import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.feignClient.AuthenticationFeignClient;
import com.cognizant.medRepSchedule.feignClient.MedicineStockFeignClient;
import com.cognizant.medRepSchedule.model.Doctor;
import com.cognizant.medRepSchedule.model.JwtResponse;
import com.cognizant.medRepSchedule.model.Representative;
import com.cognizant.medRepSchedule.model.RepresentativeSchedule;
import com.cognizant.medRepSchedule.util.CsvReader;

import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicalRepresentativeSheduleServiceImpl implements MedicalRepresentativeScheduleService {

	@Autowired
	private MedicalRepresntativeRepository medicalRepresentativeRepository;

	@Autowired
	private AuthenticationFeignClient authFeignClient;

	@Autowired
	private MedicineStockFeignClient medicineStockFeignClient;

	@Autowired
	private Environment env;

	/*
	 * This method is responsible to schedule all the meetings of representative
	 * with doctors. It will get the details of all representative from database.
	 * and get the details of all doctors from CSV file. Requirements -> Consecutive
	 * date should be taken from scheduleStartDate. -> No meetings to be scheduled
	 * on Sunday. InputParameter -> String token, LocalDate scheduleStartDate.
	 * Output -> List of Represntatives.
	 */
	@Override
	public List<RepresentativeSchedule> getRepresentativesSchedule(String token, LocalDate scheduleStartDate)
			throws InvalidDateException, InvalidTokenException {
		log.info(env.getProperty("log.start"));

		if (!isValidSession(token)) {
			log.info(env.getProperty("log.tokenExpired"));
			return null;
		}

		List<RepresentativeSchedule> repSchedules = new ArrayList<RepresentativeSchedule>();

		List<Doctor> doctors = CsvReader.parseDoctor();

		log.debug("docters : {}", doctors);

		List<Representative> medicalRepresentatives = medicalRepresentativeRepository.findAll();

		log.debug("representatives : {} ", medicalRepresentatives);

		LocalDate localDate = scheduleStartDate;

		LocalTime now = LocalTime.now();

		LocalTime one = LocalTime.of(23, 0);

		LocalDate today = LocalDate.now();
		if (scheduleStartDate.isBefore(today)) {
			log.info(env.getProperty("log.date"));
			throw new InvalidDateException("Date should be of today or later");
		}
		if (scheduleStartDate.equals(today)) {
			if (now.isAfter(one)) {
				localDate = localDate.plusDays(1);
			}
		}
		for (int i = 0; i < doctors.size(); i++) {

			if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				localDate = localDate.plusDays(1);
			}
			Doctor doctor = doctors.get(i);
			Representative medicalRepresentative = medicalRepresentatives.get(i % 3);

			RepresentativeSchedule repSchedule = new RepresentativeSchedule();
			repSchedule.setId(i + 1);
			repSchedule.setRepresentativeName(medicalRepresentative.getName());
			repSchedule.setDoctorName(doctor.getName());
			repSchedule.setDoctorContactNumber(doctor.getContactNumber());
			repSchedule.setMeetingDate(localDate);
			repSchedule.setMeetingSlot("1 PM to 2 PM");
			repSchedule.setTreatingAilment(doctor.getTreatingAilment());

			String[] medicinesByTreatingAilment = medicineStockFeignClient.getMedicinesByTreatingAilment(token,
					doctor.getTreatingAilment());

			repSchedule.setMedicines(medicinesByTreatingAilment);

			log.debug("repSchedule : {}", repSchedule);

			repSchedules.add(repSchedule);

			localDate = localDate.plusDays(1);
		}

		log.debug("repSchedules : {}", repSchedules);

		log.info(env.getProperty("log.end"));

		return repSchedules;

	}

	/*
	 * This method is responsible for validating the token. It will match the input
	 * string with the header token from authentication-service. InputParameter ->
	 * String token. Output -> Return boolean (true) if token is valid. Else throw
	 * InvalidTokenException
	 */

	public Boolean isValidSession(String token) throws InvalidTokenException {

		log.info(env.getProperty("log.start"));

		JwtResponse response = authFeignClient.verifyToken(token);
		if (!response.isValid()) {
			log.info(env.getProperty("log.tokenExpired"));
			throw new InvalidTokenException("Invalid Token");
		}

		log.info(env.getProperty("log.end"));

		return true;
	}

}
