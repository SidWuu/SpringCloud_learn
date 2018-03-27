package com.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfigClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@Autowired
	public void setEnvironment(Environment env){
		System.out.println("wxd.hello:"+env.getProperty("wxd.hello"));
	}
}
