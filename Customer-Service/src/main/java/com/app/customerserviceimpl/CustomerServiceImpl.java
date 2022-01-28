package com.app.customerserviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customerservice.ICustomerService;
import com.app.entity.Customer;
import com.app.pojos.CustomerDTO;
import com.app.repository.CustomerRepository;
import com.app.utils.CustomerDTOUtil;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO customerSignUp(CustomerDTO customerDTO) {
		Customer customer = CustomerDTOUtil.getCustomerModel(customerDTO);
		return CustomerDTOUtil.getCustomerDTO(customerRepository.save(customer));
	}

}
