package com.app.customerservice;

import java.util.List;

import com.app.pojos.CustomerDTO;

public interface ICustomerService {

	CustomerDTO customerSignUp(CustomerDTO customerDTO);
	CustomerDTO getCustomerById(Integer customerId);
	List<CustomerDTO> getAllCustomers();
	CustomerDTO updateCustomer(CustomerDTO customerDTO);
	void deleteCustomer(Integer customerId);
}
