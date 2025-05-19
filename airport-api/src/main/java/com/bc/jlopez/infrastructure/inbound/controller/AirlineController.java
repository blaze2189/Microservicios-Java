package com.bc.jlopez.infrastructure.inbound.controller;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airline;
import com.bc.jlopez.domain.service.AirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    private Logger logger = LoggerFactory.getLogger(AirlineController.class);

    private final AirlineService airlineService;

    public AirlineController(@Autowired AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Airline> getAirlineByCode(@PathVariable(required = true) String code) {

        var airline = airlineService.findByCode(code);

        return ResponseEntity.ofNullable(airline);
    }

    @GetMapping("")
    public ResponseEntity<List<Airline>> getAllAirlines() {

        var airlineList = airlineService.findAll();

        return ResponseEntity.ofNullable(airlineList);
    }

}
