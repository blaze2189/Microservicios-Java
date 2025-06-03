package com.bc.jlopez.infrastructure.inbound.controller;


import com.bc.jlopez.infrastructure.outbound.database.entity.Airport;
import com.bc.jlopez.domain.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(@Autowired AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Airport> getAirportByCode(@PathVariable(required = false) String code) {

        var airport = airportService.findByCode(code);

        return ResponseEntity.ofNullable(airport);
    }

    @GetMapping("")
    public ResponseEntity<List<Airport>> getAllAirports() {

        var airportList= airportService.findAll();

        return ResponseEntity.ofNullable(airportList);
    }

}
