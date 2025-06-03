package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "flight", catalog = "docker")
@IdClass(FlightId.class)
public class Flight implements Serializable {

    @Id
    private String code;
    @Id
    private String codeAirline;
    @ManyToOne
    @JoinColumn(name="origin")
    private Airport origin;
    @ManyToOne
    @JoinColumn(name="destiny")
    private Airport destiny;

    public Flight() {
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
