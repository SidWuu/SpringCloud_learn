package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/************************************************
 * Copyright (c)  by goldensoft
 * All right reserved.
 * Create Date: 2017年6月9日
 * Create Author: wxd
 * File Name: ProducerApplication
 * Last version:  1.0
 * Function: 服务提供者启动类
 * Last Update Date:
 * Change Log:
**************************************************/	
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
public class ProducerCopyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProducerCopyApplication.class, args);
	}
}
