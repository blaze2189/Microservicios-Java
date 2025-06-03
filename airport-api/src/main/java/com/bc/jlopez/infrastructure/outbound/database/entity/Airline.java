package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "airline", catalog = "docker")
public class Airline implements Serializable {
    @Id
    private String code;
    private String name;

    public Airline() {
    }

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "code: " + code + " - name: " + name;
    }

}
