package com.bc.jlopez.domain.service;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airport;

import java.util.List;

public sealed interface AirportService permits AirportServiceImpl{

    Airport findByCode(String code);

    List<Airport> findAll();
}
