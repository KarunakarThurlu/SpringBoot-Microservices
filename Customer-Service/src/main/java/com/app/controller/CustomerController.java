package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customerservice.ICustomerService;
import com.app.pojos.CustomerDTO;
import com.app.pojos.Response;

@RequestMapping("/customer")
@RestController
public class CustomerController {

	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/signup")
	public Response<CustomerDTO> customerSignUp(@Valid @RequestBody CustomerDTO customerDTO){
		CustomerDTO savedCustomer = customerService.customerSignUp(customerDTO);
		return new Response<>(savedCustomer,"Registered Successfully",HttpStatus.ACCEPTED);
	}
	
	

	
}
