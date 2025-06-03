package com.bc.jlopez.infrastructure.outbound.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.soabase.recordbuilder.core.RecordBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

//@RecordBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Flight(String flightCode,
                     LocalDate date,
                     String time,
                     String origin,
                     String destiny) {


}
