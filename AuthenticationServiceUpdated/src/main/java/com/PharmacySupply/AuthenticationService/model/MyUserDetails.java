package com.PharmacySupply.AuthenticationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
/*******************************************************
 * MyUserDetails class is a Entity Class which is map with
 * h2-database table and use to store the user details
 * like user id,name,password,email,number
********************************************************/
public class MyUserDetails {
	@Id
	private String userid;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String password;
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private String number;
	
	
}
