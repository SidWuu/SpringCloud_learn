package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/************************************************
 * Copyright (c)  by goldensoft
 * All right reserved.
 * Create Date: 2017年6月9日
 * Create Author: wxd
 * File Name: ConsumerApplication
 * Last version:  1.0
 * Function: 服务调用者启动类
 * Last Update Date:
 * Change Log:
**************************************************/	
//自带简单轮询负载均衡 先启动服务提供者
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
