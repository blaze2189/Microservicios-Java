package com.bc.jlopez.domain.service;

import com.bc.jlopez.application.port.BuyFlight;
import com.bc.jlopez.application.port.SearchFlight;
import com.bc.jlopez.domain.model.FlightSearch;
import com.bc.jlopez.infrastructure.outbound.database.repository.FlightDAO;
import com.bc.jlopez.infrastructure.outbound.rest.client.AirportClient;
import com.bc.jlopez.infrastructure.outbound.rest.model.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightService implements BuyFlight, SearchFlight {

    private static final Logger log = LoggerFactory.getLogger(FlightService.class);
    private final AirportClient airportClient;
    private final FlightDAO flightDAO;

    public FlightService(@Autowired AirportClient airportClient,
                         @Autowired FlightDAO flightDAO) {
        this.airportClient = airportClient;
        this.flightDAO = flightDAO;
    }

    public List<Flight> getMap() {
        return airportClient.findFlights();
    }

    @Override
    public int sellTicket(String flightCode, Integer ticketNumbers) {

        var flight = flightDAO.findFlightByCode(flightCode);

        return Optional.ofNullable(flight).map(f -> {
            var limit = f.getModelAirplane().getCapacity();
            var currentSell = f.getSoldTicket();

            var newSoldTickets = currentSell + ticketNumbers;

            if (limit <= newSoldTickets) {
                return 0;
            }

            f.setSoldTicket(newSoldTickets);
            flightDAO.save(f);

            return 1;
        }).orElse(0);
    }

    @Override
    public List<FlightSearch> searchFlight(String from, String to, String stringLocalDate) {

        List<Flight> flightsList = airportClient.findFlights(from, to);

        log.info("Response received size {}",flightsList.size());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        var localDate = LocalDate.parse(stringLocalDate,formatter);

        return flightsList.stream().
                map(flight -> addDate(flight, localDate)).
                toList().stream().
                filter(Objects::nonNull).
                toList();
    }

    private FlightSearch addDate(Flight flight, LocalDate localDate) {

        var flightDBEntity = flightDAO.findFlightByCodeEndsWithIgnoreCaseAndDate(flight.flightCode(), localDate);

        return Optional.ofNullable(flightDBEntity).
                map(f ->new FlightSearch(f.getCode(), f.getDate(), f.getTime(), flight.origin(), flight.destiny())).
                orElse(null);
    }
}
