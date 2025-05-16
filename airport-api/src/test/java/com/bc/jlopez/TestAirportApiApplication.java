package com.bc.jlopez;

import org.springframework.boot.SpringApplication;

public class TestAirportApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(AirportApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
