package com.app.pojos;

import org.springframework.http.HttpStatus;


public class ServiceDownResponse {
	
	private HttpStatus statusCode;
	private String message;
	
	public ServiceDownResponse(HttpStatus statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public ServiceDownResponse() {
		super();
	}
	
}
