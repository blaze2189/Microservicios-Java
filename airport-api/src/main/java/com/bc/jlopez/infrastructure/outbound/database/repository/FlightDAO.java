package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airport;
import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDAO extends JpaRepository<Flight,String>  {

    List<Flight> findByCodeAirline(String codeAirline);

    //List<Flight> findByOriginAndDestiny(Airport from, Airport to);

    List<Flight> findByOriginCityCodeCityCodeAndDestinyCityCodeCityCode(String origin,String destiny);

    List<Flight> findByOrigin(Airport from);

    List<Flight> findByDestiny(Airport to);

   /* List<Flight> findByDestiny(Airport destiny);
    List<Flight> findByOrigin(Airport origin);
    List<Flight> findByOriginAndDestiny(String origin,String destiny);*/

}
