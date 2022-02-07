package com.app.pojos;

import java.time.LocalDateTime;
import java.util.List;

import com.app.entity.ProductStock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
	
    private Integer stockId;
	
	private LocalDateTime importedDate;
	
	private Double amount;

	private List<ProductStock>  stockProducts;
}
