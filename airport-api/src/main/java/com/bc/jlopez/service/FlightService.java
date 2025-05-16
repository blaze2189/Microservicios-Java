package com.bc.jlopez.service;

import com.bc.jlopez.entity.Flight;

import java.util.List;

public sealed  interface FlightService permits FlightServiceImpl{
    List<Flight> getFlightByAirline(String airline);

    List<Flight> findAll();
}
