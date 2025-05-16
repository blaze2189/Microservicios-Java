package com.bc.jlopez.controller;


import com.bc.jlopez.entity.Airport;
import com.bc.jlopez.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Airport getAirportByCode(@PathVariable(required = false) String code) {

        return airportService.findByCode(code);
    }

    @GetMapping("")
    public List<Airport> getAllAirports() {

        return airportService.findAll();
    }

}
