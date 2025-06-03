package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "flight", catalog = "docker")
@IdClass(FlightId.class)
public class Flight implements Serializable {

    @Id
    private String code;
    @Id
    private String codeAirline;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin")
    private Airport origin;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destiny")
    private Airport destiny;
    private LocalTime day_time;

    public Flight() {
    }

    public String getCode() {
        return code;
    }

    public String getCodeAirline() {
        return codeAirline;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestiny() {
        return destiny;
    }

    public LocalTime getTime() {
        return day_time;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "code='" + code + '\'' +
                ", codeAirline='" + codeAirline + '\'' +
                ", origin='" + origin + '\'' +
                ", destiny='" + destiny + '\'' +
                '}';
    }
}
