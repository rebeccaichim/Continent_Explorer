package com.example.continent_explorer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long continentId;

    @Column(name = "continent_name", nullable = false, length = 50)
    private String continentName;

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }
}
