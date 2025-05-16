package com.bc.jlopez.service;

import com.bc.jlopez.entity.Airport;
import com.bc.jlopez.repository.AirportDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public final class AirportServiceImpl implements AirportService {

    private Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);

    private final AirportDAO airportDAO;

    public AirportServiceImpl(@Autowired AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    @Override
    public Airport findByCode(String code){

        logger.info("Find airport {}",code);
        var airport = airportDAO.findById(code);

        return Optional.of(airport).get().orElse(new Airport());
    }

    @Override
    public List<Airport> findAll() {
        return Optional.of(airportDAO.findAll()).orElse(Collections.emptyList());
    }

}
