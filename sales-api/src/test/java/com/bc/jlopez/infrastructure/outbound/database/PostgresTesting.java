package com.bc.jlopez.infrastructure.outbound.database;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Testcontainers
public class PostgresTesting {

    private static final String DB_CONTAINER_NAME = "airport_db";
    private static final String DB_CONTAINER_VERSION ="02";
    private static final DockerImageName DOCKER_IMAGE_NAME = DockerImageName.
            parse(DB_CONTAINER_NAME+":"+DB_CONTAINER_VERSION).
            asCompatibleSubstituteFor("postgres");
    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DOCKER_IMAGE_NAME);

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
    public void testSomethingWithDataBase() throws SQLException {

        String jdbcUrl = postgres.getJdbcUrl();
        String username = postgres.getUsername();
        String password = postgres.getPassword();

        System.out.println(
                "url "+postgres.getJdbcUrl()+"\n user:pwd "+postgres.getUsername()+":"+postgres.getPassword()
        );

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {
            var resultSet = stmt.executeQuery("select * from flight where code='019'");

            if (resultSet.next()) {
                String name = resultSet.getString("origin");
                assertEquals("LGA", name);
            } else {
                throw new SQLException("No data found in the table");
            }

        }

    }

}
