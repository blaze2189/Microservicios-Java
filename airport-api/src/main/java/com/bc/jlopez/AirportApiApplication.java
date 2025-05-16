package com.bc.jlopez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.bc.jlopez.repository")
public class AirportApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportApiApplication.class, args);
	}

}
