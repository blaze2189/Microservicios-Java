package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightDAO extends JpaRepository<Flight, String> {

    Flight findFlightByCode(String flightCode);

    List<Flight> findFlightByCodeEndsWithIgnoreCase(String code);

    Flight findFlightByCodeEndsWithIgnoreCaseAndDate(String code, LocalDate startDate);

    List<Flight> findFlightByCodeEndsWithIgnoreCaseAndDateBetween(String code, LocalDate startDate, LocalDate endDate);
    /*@Modifying
    @Query("update flight f set f.soldTicket =?1 where code=?2")
    int updateSoldTicket(Integer soldTicket, String code);*/
}
