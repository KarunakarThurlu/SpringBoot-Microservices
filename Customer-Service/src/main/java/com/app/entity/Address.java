package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_ADDRESS_TABLE")
public class Address {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer addressId;
	 private String  streetName;
	 private String  zipCode;
	 private String  cityName;
	 private String  stateName;
	 
	@Override
	public String toString() {
		return "{ addressId : " + addressId + ", streetName : " + streetName + ", zipCode : " + zipCode + ", cityName : "+ cityName + ", stateName : "+stateName +" }";
	} 
}
