package com.cognizant.medRepSchedule.service;

import java.util.List;

import com.cognizant.medRepSchedule.exception.InvalidTokenException;
import com.cognizant.medRepSchedule.model.Representative;

public interface RepresentativeService {

	public List<Representative> getMedicalRepresentatives(String token) throws InvalidTokenException;

}
  