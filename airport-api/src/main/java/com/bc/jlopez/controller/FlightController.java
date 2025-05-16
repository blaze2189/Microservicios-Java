package com.bc.jlopez.controller;

import com.bc.jlopez.entity.Flight;
import com.bc.jlopez.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(@Autowired FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{airline}")
    public List<Flight> findFlightByAirline(@PathVariable(required = true) String airline){

        return flightService.getFlightByAirline(airline);
    }

    @GetMapping
    public List<Flight> findAll(){

        return flightService.findAll();
    }

}
