package com.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private  String errorCode;
	private  String message;
	

}
