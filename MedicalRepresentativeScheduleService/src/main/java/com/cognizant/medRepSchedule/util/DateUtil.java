package com.cognizant.medRepSchedule.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/*
 * this class is responsible for parsing string date to specified
 * format(yyyy-MM-dd) of LocalDate.
 */
public class DateUtil {

	public static LocalDate getDate(String scheduleStartDate) {

		LocalDate localDate = null;
		try {

			log.info("Start");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			localDate = LocalDate.parse(scheduleStartDate, formatter);

			log.debug("localDate : {}", localDate);

		} catch (Exception e) {
			log.error("Date Format Exception");
		}

		log.info("End");

		return localDate;
	}

}
