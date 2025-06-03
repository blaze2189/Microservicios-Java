package com.bc.jlopez.domain.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Testcontainers
@SpringBootTest
class FlightServiceTest {

    private static final String DB_CONTAINER_NAME = "airport_db";
    private static final String DB_CONTAINER_VERSION = "05";
    private static final DockerImageName DOCKER_IMAGE_NAME = DockerImageName.
            parse(DB_CONTAINER_NAME + ":" + DB_CONTAINER_VERSION).
            asCompatibleSubstituteFor("postgres");
    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DOCKER_IMAGE_NAME);

    @Autowired
    private FlightService flightService;

    @BeforeAll
    public static void start() {
        postgres.start();
        System.out.println(postgres.isRunning());
    }

    @AfterAll
    public static void stop() {
        postgres.stop();
        System.out.println(postgres.isRunning());
    }

    @Test
    void findFlightsWithFilter() {

        var flightModelList = flightService.findFlightsWithFilter("NY", "CDMX");
        flightModelList.forEach(System.out::println);
        assertFalse(flightModelList.isEmpty());

    }
}