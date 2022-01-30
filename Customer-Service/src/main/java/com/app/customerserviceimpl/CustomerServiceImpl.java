package com.app.customerserviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.constants.CommonConstants;
import com.app.customerservice.ICustomerService;
import com.app.entity.Customer;
import com.app.pojos.CustomerDTO;
import com.app.pojos.CustomerException;
import com.app.repository.CustomerRepository;
import com.app.utils.CustomerDTOUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {


	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO customerSignUp(CustomerDTO customerDTO) {
		Customer customer = CustomerDTOUtil.getCustomerModel(customerDTO);
		customerRepository.findByEmail(customerDTO.getEmail()).ifPresent(cus->{
			throw new CustomerException(CommonConstants.CUSTOMER_ALREADY_EXITS,cus.getEmail()+ " Already Exists!");
		});
		return CustomerDTOUtil.getCustomerDTO(customerRepository.save(customer));
	}

	@Override
	public CustomerDTO getCustomerById(Integer customerId) {
		Customer customer =  customerRepository.findByCustomerId(customerId).orElseThrow(()->new CustomerException(CommonConstants.CUSTOMER_NOT_FOUND,"Customer not found with : "+customerId));				  
		return CustomerDTOUtil.getCustomerDTO(customer);

	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(CustomerDTOUtil::getCustomerDTO).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub

	}

}
