package com.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
    @Id
    private String productId;
    private String productBrandName;
    private String productModel;
    private Color  productColor;
    private String productName;
    private String productDescription;
    private Double productPrice;
}
