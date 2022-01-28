package com.app.model;

import javax.persistence.Entity;
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
