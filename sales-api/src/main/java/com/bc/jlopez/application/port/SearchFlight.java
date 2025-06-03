package com.bc.jlopez.application.port;

import com.bc.jlopez.domain.model.FlightSearch;

import java.time.LocalDate;
import java.util.List;

public interface SearchFlight {

    List<FlightSearch> searchFlight(String from, String to, String localDate);

}
