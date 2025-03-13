package com.sprint.btb.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistry {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistry.class, args);
		System.out.println("Eureka Server running on 8761");
	}

}
