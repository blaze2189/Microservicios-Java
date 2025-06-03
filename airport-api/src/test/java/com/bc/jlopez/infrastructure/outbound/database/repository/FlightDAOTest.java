package com.bc.jlopez.infrastructure.outbound.database.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.*;

@Testcontainers
@SpringBootTest
class FlightDAOTest {

    private static final String DB_CONTAINER_NAME = "airport_db";
    private static final String DB_CONTAINER_VERSION ="05";
    private static final DockerImageName DOCKER_IMAGE_NAME = DockerImageName.
            parse(DB_CONTAINER_NAME+":"+DB_CONTAINER_VERSION).
            asCompatibleSubstituteFor("postgres");
    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DOCKER_IMAGE_NAME);

    @Autowired
    private FlightDAO flightDAO;

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
    public void testFindByOriginAndDestiny(){

        var flitghtList = flightDAO.findByOriginCityCodeCityCodeAndDestinyCityCodeCityCode("NY","CDMX");
        flitghtList.forEach(System.out::println);

        assertFalse(flitghtList.isEmpty());

    }

}