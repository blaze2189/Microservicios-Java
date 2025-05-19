package com.bc.jlopez.domain.service;

import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;

import java.util.List;

public sealed  interface FlightService permits FlightServiceImpl{
    List<Flight> getFlightByAirline(String airline);

    List<Flight> findAll();
}
