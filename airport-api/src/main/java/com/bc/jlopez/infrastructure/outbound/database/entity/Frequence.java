package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="frequence",catalog = "docker")
public class Frequence implements Serializable {

    @Id
    private String code;
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumns({
           @JoinColumn(name = "code_flight",referencedColumnName = "code"),
           @JoinColumn(name = "code_airline",referencedColumnName = "codeAirline")
   })
    private Flight codeFlight;
    private char codeDay;

    public Frequence() {
    }

    public String getCode() {
        return code;
    }

    public Flight getCodeFlight() {
        return codeFlight;
    }

    public char getCodeDay() {
        return codeDay;
    }
}
