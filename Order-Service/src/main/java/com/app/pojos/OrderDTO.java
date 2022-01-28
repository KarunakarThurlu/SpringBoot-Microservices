package com.app.pojos;

import java.time.LocalDateTime;
import java.util.List;

import com.app.model.Address;
import com.app.model.Customer;
import com.app.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Integer orderId;
	
	private LocalDateTime orderDate;
	
	private Double orderAmount;
	
	private Address shipingAddress;
	
	private List<Product> orderProducts;
	
	private Customer customer;

	@Override
	public String toString() {
		return "{ orderId : " + orderId + ", orderDate : " + orderDate + ", orderAmount : " + orderAmount+ ", shipingAddress : " + shipingAddress + ", orderProducts : " + orderProducts + ", customer : " + customer+ " }";
	}
}
