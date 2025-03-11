package com.example.dine_in_order_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DineInOrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DineInOrderApiApplication.class, args);
	}

}
