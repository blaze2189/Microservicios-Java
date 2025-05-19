package com.bc.jlopez.domain.service;

import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;
import com.bc.jlopez.infrastructure.outbound.database.repository.FlightDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class FlightServiceImpl implements FlightService {

    private Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);

    private final FlightDAO flightDAO;

    public FlightServiceImpl(@Autowired FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    public List<Flight> getFlightByAirline(String airline){

        log.info("Searching Airline {}",airline);
        var flightList = flightDAO.findByCodeAirline(airline);
        //var flightList = flightDAO.findAll();

        flightList.forEach(System.out::println);

        return Optional.of(flightList).get();

    }

    @Override
    public List<Flight> findAll() {

        return flightDAO.findAll();
    }
}
