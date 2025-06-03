package com.bc.jlopez.domain.model;

public enum City {

    CDMX("Ciudad de México"),
    NY("New York"),
    GDL("Guadalajara");

    private final String cityCode;

    City(String cityCode) {
        this.cityCode = cityCode;
    }

}
