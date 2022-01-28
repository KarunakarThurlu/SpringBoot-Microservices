package com.app.serviceiml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.iservice.ICustomerService;
import com.app.model.Customer;
import com.app.pojos.CustomerDTO;
import com.app.repository.CustomerRepository;
import com.app.util.DTOUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {


	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO customerSignUp(CustomerDTO customerDTO) {
		Customer customer =	DTOUtil.getCustomerModel(customerDTO);
		return DTOUtil.getCustomerDTO(customerRepository.save(customer));
	}

}
