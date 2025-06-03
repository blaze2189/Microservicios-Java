package com.bc.jlopez.domain.service;

import com.bc.jlopez.application.port.usecase.frequence.FindFrequence;
import com.bc.jlopez.infrastructure.outbound.database.entity.Frequence;
import com.bc.jlopez.infrastructure.outbound.database.repository.FrequenceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bc.jlopez.domain.model.Flight;

import java.util.List;

@Service
public final class FrequenceService implements FindFrequence {

    private final Logger logger = LoggerFactory.getLogger(FrequenceService.class);

    private final FrequenceDAO frequenceDAO;

    public FrequenceService(@Autowired FrequenceDAO frequenceDAO){
        this.frequenceDAO=frequenceDAO;
    }

    @Override
    public List<Flight> findAllFrequence() {
        var frequenceList = frequenceDAO.findAll();

        var flightList = frequenceList.stream().map(this::buildFlight).toList();



        return flightList;
    }

    private Flight buildFlight(Frequence frequence) {

        var codeFlight = frequence.getCode();
        var time = frequence.getCodeFlight().getTime();

        return null;//new Flight(codeFlight,null,time);
    }
}
