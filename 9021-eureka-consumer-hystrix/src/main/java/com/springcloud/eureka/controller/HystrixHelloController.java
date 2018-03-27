package com.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.eureka.remote.HystrixHelloRemote;
import com.springcloud.eureka.remote.HystrixHiRemote;

@RestController
public class HystrixHelloController {
	@Autowired
	private HystrixHelloRemote helloRemote;
	@Autowired
	private HystrixHiRemote hiRemote;
	
	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name")String name){
		String str="";
		for(int i=0;i<15;i++){
			str+=helloRemote.hello(name)+"<br/>";
		}
		return str;
	}
	
	@RequestMapping("/hi/{name}")
	public String hi(@PathVariable("name")String name){
		String str = "";
		for(int i=0;i<15;i++){
			str+=hiRemote.hi(name)+"<br/>";
		}
		return str;
	}
	
	@RequestMapping("/queryCustomer.do")
	public ModelMap queryCustomer(){
		return helloRemote.queryCustomer();
	}
}
