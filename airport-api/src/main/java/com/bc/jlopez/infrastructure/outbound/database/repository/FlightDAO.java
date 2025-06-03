package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightDAO extends JpaRepository<Flight,String>  {

    List<Flight> findByCodeAirline(String codeAirline);
   /* List<Flight> findByDestiny(Airport destiny);
    List<Flight> findByOrigin(Airport origin);
    List<Flight> findByOriginAndDestiny(String origin,String destiny);*/

}
