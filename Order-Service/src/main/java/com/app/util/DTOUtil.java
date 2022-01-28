package com.app.util;

import java.util.function.Function;

import com.app.model.Customer;
import com.app.model.Order;
import com.app.pojos.CustomerDTO;
import com.app.pojos.OrderDTO;

public class DTOUtil {

	public static  Customer getCustomerModel(CustomerDTO customerDTO) {
		Customer customer=new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setAddress(customerDTO.getAddress());
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
		customerDTO.setAddress(customer.getAddress());
		return customerDTO;
	}

	public Function<Order, OrderDTO> getOrderDTO = (order) -> {

		return null;
	};
}
