package com.bc.jlopez.entity;

import jakarta.persistence.*;
import org.hibernate.usertype.UserType;

import java.io.Serializable;

@Entity
@Table(name = "city_country",catalog = "docker")
public class CityCountry implements Serializable {

    @Id
    private String cityCode;
    @ManyToOne
    @JoinColumn(name="country_code")
    private Country countryCode;
    private String cityName;

    public CityCountry() {}

    public String getCityCode() {
        return cityCode;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public String getCityName() {
        return cityName;
    }
}
