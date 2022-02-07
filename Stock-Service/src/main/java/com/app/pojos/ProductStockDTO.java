package com.app.pojos;

import com.app.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDTO {
	private Integer productStockId;
	private String  productId;
	private Integer productCount;
	private Integer productSoldCount;
	private Status  productStatus;
}
