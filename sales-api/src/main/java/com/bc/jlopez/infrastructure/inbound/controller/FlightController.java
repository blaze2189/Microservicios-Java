package com.bc.jlopez.infrastructure.inbound.controller;

import com.bc.jlopez.domain.model.FlightSearch;
import com.bc.jlopez.domain.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {

    private Logger logger = LoggerFactory.getLogger(FlightController.class);

    private FlightService flightService;

    public FlightController(@Autowired FlightService flightService) {
        this.flightService = flightService;
    }

    @PutMapping("/buy")
    public ResponseEntity<String> buyTickets(@RequestParam("flightCode") String flightCode, @RequestParam("tickets") Integer tickets) {

        var sellTicket = flightService.sellTicket(flightCode, tickets);

        if (sellTicket > 0) {

            logger.info("Tickets sold");

            return ResponseEntity.accepted().body("Tickets sold");
        }

        logger.info("Tickets not sold");

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping
    public ResponseEntity<List<FlightSearch>> findFlights(@RequestParam("from") String from,
                                                          @RequestParam("to") String to,
                                                          @RequestParam("date") String localDate) {

        logger.info("Flight from {} to {} in date {}", from, to, localDate);
        var flightSearch = flightService.searchFlight(from,to,localDate);

        if(flightSearch.isEmpty()){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(flightSearch);
    }

}
