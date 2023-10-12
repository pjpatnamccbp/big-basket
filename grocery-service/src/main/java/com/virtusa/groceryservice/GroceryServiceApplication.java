package com.virtusa.groceryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GroceryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryServiceApplication.class, args);
	}

}
