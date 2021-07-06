package com.cognizant.pharmacysupply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;

/**
 * The Class Java Persistence API  is the standard way of persisting Java objects into
 *  relational databases of PharmacyMedicineSupply and to perform CRUD operations on the PharmacyMedicineSupply Table.
 */

@Repository
public interface PharmacyMedicineSupplyRepository extends JpaRepository<PharmacyMedicineSupply, Integer>{

}
