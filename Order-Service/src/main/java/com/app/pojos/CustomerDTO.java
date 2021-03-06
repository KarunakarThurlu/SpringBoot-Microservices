package com.app.pojos;

import java.util.Set;

import com.app.enums.Gender;
import com.app.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	
	private Integer customerId;
	private String  firstName;
	private String  lastName;
	private String  email;
	private String  password;
	private String  phoneNumber;
	private Gender  gender;
	private Set<Address> address;
	
}
