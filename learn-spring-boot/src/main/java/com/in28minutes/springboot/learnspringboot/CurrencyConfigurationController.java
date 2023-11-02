package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfiguration configuration;

	//http://localhost:8080/courses 입력시 데이터 반환
	// Course: id, name, author
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveAllCources() {
		return configuration;
	}

}
