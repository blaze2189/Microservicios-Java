package com.bc.jlopez.infrastructure.outbound.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="country",catalog = "docker")
public class Country implements Serializable {

    @Id
    private String code;
    private String name;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
