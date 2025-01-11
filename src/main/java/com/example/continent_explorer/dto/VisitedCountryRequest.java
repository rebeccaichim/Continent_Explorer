package com.example.continent_explorer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VisitedCountryRequest {
    private String visitedCountryName;
    private Long continentId;
    private Long userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formatul datei

    private String countryVisitedDate;

    // Getteri și setteri
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

    public String getCountryVisitedDate() {
        return countryVisitedDate;
    }

    public void setCountryVisitedDate(String countryVisitedDate) {
        this.countryVisitedDate = countryVisitedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
