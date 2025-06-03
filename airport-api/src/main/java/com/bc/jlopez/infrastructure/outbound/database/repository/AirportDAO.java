package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDAO extends JpaRepository<Airport,String> {


}
