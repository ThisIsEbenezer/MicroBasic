package com.htc.product.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
public class UserController {
	

	
	@CrossOrigin(origins = "*")
	@GetMapping(value="All/", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> viewUsers() {
		 List<String> getUser = Arrays.asList("Product1","Product2");		
		return getUser;
	}

}
