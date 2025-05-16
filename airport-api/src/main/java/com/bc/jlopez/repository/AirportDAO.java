package com.bc.jlopez.repository;

import com.bc.jlopez.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportDAO extends JpaRepository<Airport,String> {


}
