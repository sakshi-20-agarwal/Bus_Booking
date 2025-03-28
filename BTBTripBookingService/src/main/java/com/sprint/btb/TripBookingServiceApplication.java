package com.sprint.btb;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TripBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripBookingServiceApplication.class, args);
		System.out.println("TripBooking Service is running on 9093 Port !!");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
