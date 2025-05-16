package com.bc.jlopez.service;

import com.bc.jlopez.entity.Airport;

import java.util.List;

public sealed interface AirportService permits AirportServiceImpl{

    Airport findByCode(String code);

    List<Airport> findAll();
}
