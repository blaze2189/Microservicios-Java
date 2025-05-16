package com.bc.jlopez.controller;

import com.bc.jlopez.entity.Airline;
import com.bc.jlopez.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(@Autowired AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/{code}")
    public Airline getAirlineByCode(@PathVariable (required = true) String code){

        return airlineService.findByCode(code);
    }

    @GetMapping("")
    public List<Airline> getAllAirlines(){

        return airlineService.findAll();
    }

}
