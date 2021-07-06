package com.cognizant.medRepSchedule.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

/*
 * This class is responsible for listing out details of all scheduled meetings.
 * all representative has to mapped with respective doctors.
 */
public class RepresentativeSchedule {
 
	private int id;
	private String representativeName;
	private String doctorName;
	private String meetingSlot;
	private LocalDate meetingDate;
	private String doctorContactNumber;
	private String[] medicines;
	private String treatingAilment;

}
