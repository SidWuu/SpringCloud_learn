package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	//启动注册服务
public class Peer1EurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(Peer1EurekaApplication.class, args);
	}
}
