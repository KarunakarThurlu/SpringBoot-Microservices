package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.app.enums.Color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product_table")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    private String productBrandName;
    private String productModel;
    private Color  productColor;
    private String productName;
    private String productDescription;
    private Double productPrice;
    
	@Override
	public String toString() {
		return "{ productId : " + productId + ", productBrandName : " + productBrandName + ", productModel : "
				+ productModel + ", productColor : " + productColor + ", productName : " + productName
				+ ", productDescription : " + productDescription + ", productPrice : " + productPrice + " }";
	} 
}
