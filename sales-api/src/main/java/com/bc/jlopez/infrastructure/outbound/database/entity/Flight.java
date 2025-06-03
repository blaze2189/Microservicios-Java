package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "flight", catalog = "docker")
public class Flight {

    @Id
    private String code;
    @ManyToOne
    @JoinColumn(name = "model_airplane")
    private Airplane modelAirplane;
    private Integer soldTicket;
    private LocalDate date;
    private LocalTime time;

    public Flight() {
    }

    public String getCode() {
        return code;
    }

    public Airplane getModelAirplane() {
        return modelAirplane;
    }

    public Integer getSoldTicket() {
        return soldTicket;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setModelAirplane(Airplane modelAirplane) {
        this.modelAirplane = modelAirplane;
    }

    public void setSoldTicket(Integer soldTicket) {
        this.soldTicket = soldTicket;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
