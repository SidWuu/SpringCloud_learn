package com.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/************************************************
 * Copyright (c)  by goldensoft
 * All right reserved.
 * Create Date: 2017年10月10日
 * Create Author: wxd
 * File Name: 实时监控
 * Last version:  1.0
 * Function: 这里写注释
 * Last Update Date:
 * Change Log:
**************************************************/	
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class TurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
