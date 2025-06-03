package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airplane", catalog = "docker")
public class Airplane {

    @Id
    private String model;
    private String name;
    private Integer capacity;

    public Airplane() {
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
