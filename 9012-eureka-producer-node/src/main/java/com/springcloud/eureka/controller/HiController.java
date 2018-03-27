package com.springcloud.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.eureka.service.CustomerService;
import com.springcloud.eureka.vo.Customer;

@RestController
public class HiController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/hi")
	public String hello(@RequestParam String name){
		return "hi "+name+", this is your node message!";
	}
	
	@RequestMapping("/queryCustomer.do")
	public ModelMap queryCustomer(){
		ModelMap modelMap=new ModelMap();
		try {
			List<Customer> list=customerService.query();
			modelMap.put("success", "success");
			modelMap.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("failure", e.getMessage());
		}
		return modelMap;
	}
}
