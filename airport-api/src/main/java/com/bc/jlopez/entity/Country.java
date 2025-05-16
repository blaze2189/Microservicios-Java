package com.bc.jlopez.entity;

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

    public String getCode() {
        return code;
    }

}
