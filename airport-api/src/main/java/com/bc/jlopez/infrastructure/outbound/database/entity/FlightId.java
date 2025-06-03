package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

public class FlightId implements Serializable {

    private String code;
    private String codeAirline;

}
