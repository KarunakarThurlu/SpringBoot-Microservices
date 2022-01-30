package com.app.utils;


import java.time.LocalDate;

import com.app.entity.Customer;
import com.app.pojos.CustomerDTO;


public class CustomerDTOUtil {
	
	private  CustomerDTOUtil() {
		super();
	}
	public static  Customer getCustomerModel(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setAddress(customerDTO.getAddress());
		LocalDate dob= customerDTO.getDateOfBirth();
		customer.setDateOfBirth(dob);
		customer.setRoles(customerDTO.getRoles());
		return customer;
	}

	public static CustomerDTO getCustomerDTO(Customer customer) {
		CustomerDTO customerDTO=new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setGender(customer.getGender());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setRoles(customer.getRoles());
		return customerDTO;
	}
}

