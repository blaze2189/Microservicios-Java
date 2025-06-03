package com.bc.jlopez.application.port.usecase.flight;

import com.bc.jlopez.domain.model.Flight;

import java.util.List;

public interface FindFlight {

    List<Flight> getFlightByAirline(String airline);

    List<Flight> findAll();

    List<Flight> findFlightsWithFilter(String from, String to);

}
