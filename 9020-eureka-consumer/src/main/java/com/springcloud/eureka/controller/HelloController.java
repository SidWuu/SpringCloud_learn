package com.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.eureka.remote.HelloRemote;
import com.springcloud.eureka.remote.HiRemote;

@RestController
public class HelloController {
	@Autowired
	private HelloRemote helloRemote;
	@Autowired
	private HiRemote hiRemote;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name")String name){
		String str="";
		for(int i=0;i<10;i++){
			str+=helloRemote.hello(name)+"<br/>";
		}
		return str;
	}
	
	@RequestMapping("/hi/{name}")
	public String hi(@PathVariable("name")String name){
		String str = "";
		for(int i=0;i<10;i++){
			str += hiRemote.hi(name)+"<br/>";
		}
		return str;
	}
	
	@RequestMapping("/queryCustomer.do")
	public ModelMap queryCustomer(){
		return helloRemote.queryCustomer();
	}
}
