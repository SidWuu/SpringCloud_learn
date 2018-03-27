package com.springcloud.eureka.remote;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HystrixHelloRemoteHystrix implements HystrixHelloRemote{

	@Override
	public String hello(@RequestParam(value="name") String name) {
		return "sorry "+name+",this method is failed!";
	}

	@Override
	public ModelMap queryCustomer() {
		return null;
	}
	
}
