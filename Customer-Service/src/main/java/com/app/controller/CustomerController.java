package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.checkerframework.common.reflection.qual.GetClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Response<CustomerDTO> customerSignUp( @RequestBody  CustomerDTO customerDTO){
		CustomerDTO savedCustomer = customerService.customerSignUp(customerDTO);
		return new Response<>(savedCustomer,"Registered Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getcustomer")
	public Response<CustomerDTO> customerSignUp( @RequestParam Integer customerId){
		CustomerDTO customer = customerService.getCustomerById(customerId);
		return new Response<>(customer,"OK",HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public Response<List<CustomerDTO>> customerSignUp(){
		List<CustomerDTO> customer = customerService.getAllCustomers();
		return new Response<>(customer,"OK",HttpStatus.OK);
	}
	
	
	
	
	

	
}
