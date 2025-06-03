package com.bc.jlopez.domain.service;

import com.bc.jlopez.application.port.usecase.flight.FindFlight;
import com.bc.jlopez.domain.model.Flight;
import com.bc.jlopez.infrastructure.outbound.database.repository.FlightDAO;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public final class FlightService implements FindFlight {

    private Logger logger = LoggerFactory.getLogger(FlightService.class);

    private final FlightDAO flightDAO;

    public FlightService(@Autowired FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    public List<Flight> getFlightByAirline(String airline) {

        logger.info("Searching Airline {}", airline);
        var flightList = flightDAO.findByCodeAirline(airline);

        flightList.forEach(System.out::println);

        return Optional.of(flightList).
                orElse(Collections.emptyList()).
                stream().
                map(this::buildFlightModel).toList();

    }

    @Override
    public List<Flight> findAll() {

        var flightList = flightDAO.findAll();

        flightList.forEach(flight -> logger.info(flight.toString()));

        return Optional.of(flightList).
                orElse(Collections.emptyList()).
                stream().
                map(this::buildFlightModel).toList();
    }

    @Override
    public List<Flight> findFlightsWithFilter(String from, String to) {

        logger.info("finding flights with filter from: {} to: {}", from, to);

        var fromOptional = Optional.ofNullable(from);
        var toOptional = Optional.ofNullable(to);

        List<com.bc.jlopez.infrastructure.outbound.database.entity.Flight> flightList = null;

        if (fromOptional.isPresent() && toOptional.isPresent()) {
            logger.info("destiny and origin defined");
            flightList = flightDAO.findByOriginCityCodeCityCodeAndDestinyCityCodeCityCode(from, to);
            //com.bc.jlopez.domain.model.Flight modelFlight = ;
        }
        if (fromOptional.isPresent() && flightList == null) {
            logger.info("origin defined");
            flightList = null;//flightDAO.findByOrigin(new Airport());
        }
        if (toOptional.isPresent() && flightList == null) {
            logger.info("destiny Defined");
            flightList = null;//flightDAO.findByDestiny(new Airport());
        }

        return Optional.ofNullable(flightList).
                orElse(Collections.emptyList()).
                stream().
                map(this::buildFlightModel).
                toList();
    }

    private Flight buildFlightModel(com.bc.jlopez.infrastructure.outbound.database.entity.Flight flight) {
        logger.info("building Flight model");
        var flightCode = Strings.concat(flight.getCodeAirline(), flight.getCode());
        var originCode = flight.getOrigin().getCityCode().getCityCode();
        var destinyCode = flight.getDestiny().getCityCode().getCityCode();
        logger.info("flight with: {}, {}, {}", flightCode, originCode, destinyCode);
        return new Flight(flightCode, null, flight.getTime(), originCode, destinyCode);
    }
}
