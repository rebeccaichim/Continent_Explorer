package com.example.continent_explorer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visited_countries")
public class VisitedCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment pentru PostgreSQL
    @Column(name = "visited_country_id")
    private Long visitedCountryId;

    @Column(name = "visited_country_name", nullable = false)
    private String visitedCountryName;

    @Column(name = "continent_id")
    private Long continentId;

    @Column(name = "country_visited_date", nullable = false)
    private LocalDate countryVisitedDate;

    @Column(name = "user_id")
    private Long userId;

    public Long getVisitedCountryId() {
        return visitedCountryId;
    }

    public void setVisitedCountryId(Long visitedCountryId) {
        this.visitedCountryId = visitedCountryId;
    }

    public String getVisitedCountryName() {
        return visitedCountryName;
    }

    public void setVisitedCountryName(String visitedCountryName) {
        this.visitedCountryName = visitedCountryName;
    }

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    public LocalDate getCountryVisitedDate() {
        return countryVisitedDate;
    }

    public void setCountryVisitedDate(LocalDate countryVisitedDate) {
        this.countryVisitedDate = countryVisitedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
