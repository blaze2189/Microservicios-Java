package com.bc.jlopez.infrastructure.inbound.controller;

import com.bc.jlopez.domain.model.Flight;
import com.bc.jlopez.domain.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    private final Logger logger = LoggerFactory.getLogger(FlightController.class);

    public FlightController(@Autowired FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{airline}")
    public ResponseEntity<List<Flight>> findFlightByAirline(@PathVariable(required = true) String airline) {

        var flightList = flightService.getFlightByAirline(airline);

        return ResponseEntity.ofNullable(flightList);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> findAll() {

        var flightList = flightService.findAll();


        return ResponseEntity.ofNullable(flightList);
    }

    @GetMapping
    public ResponseEntity flightsByOriginDestiny(@RequestParam(name = "origin", required = false) String origin,
                                                 @RequestParam(name = "destiny", required = false) String destiny) {

        var flightList = flightService.findFlightsWithFilter(origin, destiny);

        if (flightList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flightList);
    }

}
