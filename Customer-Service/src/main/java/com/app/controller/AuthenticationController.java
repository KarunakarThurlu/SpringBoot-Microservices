package com.app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.CustomerDTO;
import com.google.gson.JsonObject;

@RestController
public class AuthenticationController {

	
	public JsonObject login(@RequestBody CustomerDTO customerDTO) {
		JsonObject obj=new JsonObject();
		
		obj.addProperty("token", "");
		
		return obj;
	}
}
