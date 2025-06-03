package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Flight;
import com.bc.jlopez.infrastructure.outbound.database.entity.Frequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequenceDAO  extends JpaRepository<Frequence,String> {



}
