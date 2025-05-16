package com.bc.jlopez.repository;

import com.bc.jlopez.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineDAO extends JpaRepository<Airline,String> {

    Airline findByCode(String code);

}
