package com.bc.jlopez.service;

import com.bc.jlopez.entity.Airline;

import java.util.List;

public sealed interface AirlineService permits AirlineServiceImpl{

    Airline findByCode(String code);

    List<Airline> findAll();
}
