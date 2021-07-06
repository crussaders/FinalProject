package com.cognizant.pharmacysupply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pharmacysupply.model.MedicineDemand;

/**
 * The Class Java Persistence API  is the standard way of persisting Java objects into
 *  relational databases of MedicineDemand and to perform CRUD operations on the MedicineDemand Table.
 */
@Repository
public interface MedicineDemandRepository extends JpaRepository<MedicineDemand, Integer>{

}
