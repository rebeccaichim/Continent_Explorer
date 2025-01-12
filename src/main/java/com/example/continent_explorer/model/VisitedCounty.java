package com.example.continent_explorer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visited_counties")
public class VisitedCounty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visited_county_id")
    private Long visitedCountyId;

    @Column(name = "visited_county_name", nullable = false)
    private String visitedCountyName;

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "county_visited_date", nullable = false)
    private LocalDate countyVisitedDate;

    @Column(name = "user_id")
    private Long userId;

    public Long getVisitedCountyId() {
        return visitedCountyId;
    }

    public void setVisitedCountyId(Long visitedCountyId) {
        this.visitedCountyId = visitedCountyId;
    }

    public String getVisitedCountyName() {
        return visitedCountyName;
    }

    public void setVisitedCountyName(String visitedCountyName) {
        this.visitedCountyName = visitedCountyName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public LocalDate getCountyVisitedDate() {
        return countyVisitedDate;
    }

    public void setCountyVisitedDate(LocalDate countyVisitedDate) {
        this.countyVisitedDate = countyVisitedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
