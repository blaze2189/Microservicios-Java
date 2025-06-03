package com.bc.jlopez.domain.service;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airline;
import com.bc.jlopez.infrastructure.outbound.database.repository.AirlineDAO;
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

        return airline;

    }

    @Override
    public List<Airline> findAll() {

        logger.info("finding all airports");

        var list = airlineDAO.findAll();
        Optional.of(list).orElse(null);
        list.forEach(a -> logger.info(a.toString()));

        return list;
    }
}
