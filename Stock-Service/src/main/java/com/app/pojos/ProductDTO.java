package com.app.pojos;



import com.app.enums.Color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    
	private String productId;
    private String productBrandName;
    private String productModel;
    private Color  productColor;
    private String productName;
    private String productDescription;
    private Double productPrice;
}
