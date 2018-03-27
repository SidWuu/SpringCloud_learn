package com.springcloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${dev-config.appName}")
	private String hello;
	
	@RequestMapping("/retHello")
	public String retHello(){
		return this.hello;
	}
}
