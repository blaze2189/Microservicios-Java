package com.bc.jlopez.infrastructure.outbound.database.repository;

import com.bc.jlopez.infrastructure.outbound.database.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneDAO extends JpaRepository<Airplane, String> {
}
