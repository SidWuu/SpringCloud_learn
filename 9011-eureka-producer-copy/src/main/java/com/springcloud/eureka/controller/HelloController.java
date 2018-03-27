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
public class HelloController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/hello")
	public String index(@RequestParam String name){
		return "hello "+name+", this is your message!<2-2-2-2-2-2-2-2-2-2-2-2-2>";
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
