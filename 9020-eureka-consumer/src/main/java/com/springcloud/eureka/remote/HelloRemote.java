package com.springcloud.eureka.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="wxd-eureka-producer"/*, fallback=HelloRemoteHystrix.class*/)
//name与远程调用的spring.application.name保持一致(不能有下划线)
public interface HelloRemote {
	
	@RequestMapping(value="/hello")
	public String hello(@RequestParam(value="name")String name);
	
	@RequestMapping(value="queryCustomer.do")
	public ModelMap queryCustomer();
}
