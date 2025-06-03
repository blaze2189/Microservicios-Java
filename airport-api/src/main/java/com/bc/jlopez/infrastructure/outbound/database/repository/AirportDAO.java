package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportDAO extends JpaRepository<Airport,String> {


}
