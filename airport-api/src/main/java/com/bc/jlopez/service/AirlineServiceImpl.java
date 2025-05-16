package com.bc.jlopez.service;

import com.bc.jlopez.entity.Airline;
import com.bc.jlopez.repository.AirlineDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class AirlineServiceImpl implements AirlineService {

    private final Logger logger = LoggerFactory.getLogger(AirlineServiceImpl.class);

    private final AirlineDAO airlineDAO;

    public AirlineServiceImpl(@Autowired AirlineDAO airlineDAO) {
        this.airlineDAO = airlineDAO;
    }

    @Override
    public Airline findByCode(String code) {

        logger.info("Code received {}", code);
        var airline = airlineDAO.findByCode(code);

        return Optional.ofNullable(airline).orElse(new Airline());

    }

    @Override
    public List<Airline> findAll() {

        logger.info("finding all airports");

        var list = airlineDAO.findAll();
        list.forEach(a -> logger.info(a.toString()));

        return airlineDAO.findAll();
    }
}
