package com.cognizant.medRepSchedule.service;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.medRepSchedule.exception.InvalidDateException;
import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.model.RepresentativeSchedule;

public interface MedicalRepresentativeScheduleService {

	public List<RepresentativeSchedule> getRepresentativesSchedule(String token, LocalDate scheduleStartDate)
			throws InvalidDateException, InvalidTokenException;

}
