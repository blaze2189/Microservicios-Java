package com.bc.jlopez.infrastructure.outbound.rest.client;

import com.bc.jlopez.infrastructure.outbound.rest.model.Flight;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AirportClient {

    Logger logger = LoggerFactory.getLogger(AirportClient.class);

    private RestClient airportRestClient;

    private String airportApiUri;

    public AirportClient(@Value("${rest.api.airport}") String airportApiUri) {
        this.airportApiUri = airportApiUri;
        apiClient();
    }

    private void apiClient() {
        airportRestClient = RestClient.
                builder().
                baseUrl(airportApiUri).
                build();
    }

    public List<Flight> findFlights() {

        final String frequence = "/frequence";
        logger.info("Request to: " + airportApiUri + frequence);

        var flightList = airportRestClient.
                get().
                uri(frequence).
                retrieve().
                toEntity(String.class).
                getBody();

        return Optional.ofNullable(flightList).
                map(this::castResponse).
                orElse(Collections.emptyList());

    }

    public List<Flight> findFlights(String from, String to) {

        logger.info("Sending request to airport api");

        final String path = "flight";
        var response = airportRestClient.get().uri(uriBuilder -> uriBuilder.path("/" + path).
                        queryParam("origin", from).
                        queryParam("destiny", to).
                        build()).
                retrieve().body(String.class);

        return Optional.ofNullable(response).
                map(this::castResponse).
                orElse(Collections.emptyList());
    }

    private List<Flight> castResponse(String response) {
        var objectMapper = new ObjectMapper();
        var responseType = objectMapper.getTypeFactory().constructCollectionType(List.class, Flight.class);
        try {
            return objectMapper.readValue(response, responseType);
        } catch (JsonProcessingException e) {
            logger.error("Error while casting response: {}", e.getMessage());
            return null;
        }
    }

}
