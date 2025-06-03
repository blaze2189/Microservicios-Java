package com.bc.jlopez.infrastructure.inbound.controller;

import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;
import com.bc.jlopez.domain.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(@Autowired FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{airline}")
    public ResponseEntity<List<Flight>> findFlightByAirline(@PathVariable(required = true) String airline){

        var flightList = flightService.getFlightByAirline(airline);

        return ResponseEntity.ofNullable(flightList);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> findAll(){

        var flightList = flightService.findAll();

        return ResponseEntity.ofNullable(flightList);
    }

}
