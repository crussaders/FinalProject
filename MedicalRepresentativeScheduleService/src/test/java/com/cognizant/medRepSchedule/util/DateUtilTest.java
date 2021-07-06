package com.cognizant.medRepSchedule.util;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medRepSchedule.exception.InvalidTokenException;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DateUtilTest {

	@Mock
	public DateUtil dateUtil;
	

	/*
	 * getDate from dateUtil and check for equality after 10 days
	 * */
	@Test
	void testScheduleDate() throws InvalidTokenException {

		log.info("Start");

		LocalDate localDate = DateUtil.getDate("2021-05-17");
		assertEquals(LocalDate.now().plusDays(10), localDate);
		log.info("End");

	}

}
