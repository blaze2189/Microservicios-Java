package com.bc.jlopez.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record FlightSearch(String flightCode,
                          LocalDate date,
                          LocalTime time,
                          String origin,
                          String destiny) {
}
