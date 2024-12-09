package com.example.continent_explorer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "counties")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countyId;

    @Column(name = "county_name", nullable = false, length = 50)
    private String countyName;

    @Column(name = "county_abbreviation", length = 5)
    private String countyAbbreviation;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyAbbreviation() {
        return countyAbbreviation;
    }

    public void setCountyAbbreviation(String countyAbbreviation) {
        this.countyAbbreviation = countyAbbreviation;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
