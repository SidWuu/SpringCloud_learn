package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Peer3EurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(Peer3EurekaApplication.class, args);
	}
}
