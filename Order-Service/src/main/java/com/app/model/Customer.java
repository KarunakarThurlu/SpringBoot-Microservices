package com.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_TABLE")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String  firstName;
	private String  lastName;
	private String  email;
	private String  password;
	private String  phoneNumber;
	private Gender  gender;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	private Set<Address> address;


	@Override
	public String toString() {
		return "{ customerId : " + customerId + ", firstName : " + firstName + ", lastName : " + lastName + ", email : "+ email + ", password : " + password + ", phoneNumber : " + phoneNumber + ", gender : " + gender + ", address : " + address + " }";
	} 
}
