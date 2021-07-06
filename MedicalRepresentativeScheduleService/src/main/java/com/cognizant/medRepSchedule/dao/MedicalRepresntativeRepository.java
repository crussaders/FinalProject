package com.cognizant.medRepSchedule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medRepSchedule.model.Representative;

/*
 * A Repository interface for Representative
 * which use all the functionality of JPA Repository
 * */
@Repository
public interface MedicalRepresntativeRepository extends JpaRepository<Representative, Integer> {

}
