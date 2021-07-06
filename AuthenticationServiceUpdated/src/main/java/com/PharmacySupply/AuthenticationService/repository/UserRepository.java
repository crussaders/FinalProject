package com.PharmacySupply.AuthenticationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PharmacySupply.AuthenticationService.model.MyUserDetails;

@Repository
/*
 * UserRepository interact with database table 
 * it provide some method to do manipulation 
 * on data which is present in table
 */
public interface UserRepository extends JpaRepository<MyUserDetails, String> {
}
