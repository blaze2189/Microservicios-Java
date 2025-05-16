package com.bc.jlopez.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="frequence",catalog = "docker")
public class Frequence implements Serializable {

    @Id
    private Integer code;
   @ManyToOne
   @JoinColumns({
           @JoinColumn(name = "code_flight",referencedColumnName = "code"),
           @JoinColumn(name = "code_airline",referencedColumnName = "codeAirline")
   })
    private Flight codeFlight;
    private char codeDay;

    public Frequence() {
    }

    public Integer getCode() {
        return code;
    }

    public Flight getCodeFlight() {
        return codeFlight;
    }

    public char getCodeDay() {
        return codeDay;
    }
}
