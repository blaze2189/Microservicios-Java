package com.bc.jlopez.domain.service;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airline;

import java.util.List;

public sealed interface AirlineService permits AirlineServiceImpl{

    Airline findByCode(String code);

    List<Airline> findAll();
}
