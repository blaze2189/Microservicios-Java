package com.bc.jlopez.domain.model;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@RecordBuilder
public record Flight(String flightCode,
                     LocalDate date,
                     LocalTime time,
                     String origin,
                     String destiny) {

}
