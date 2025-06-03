package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "airport", catalog = "docker")
public class Airport implements Serializable {

    @Id
    private String code;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_code")
    private CityCountry cityCode;
    private String name;

    public Airport() {
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public CityCountry getCityCode() {
        return cityCode;
    }

    @Override
    public String toString() {
        return "code: " + code + " - name: " + name;
    }

}
