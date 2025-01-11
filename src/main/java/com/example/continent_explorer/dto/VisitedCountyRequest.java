package com.example.continent_explorer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VisitedCountyRequest {
    private String visitedCountyName;
    private Long countryId;
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Specificăm formatul așteptat

    private String countyVisitedDate;

    // Getteri și setteri
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

    public String getCountyVisitedDate() {
        return countyVisitedDate;
    }

    public void setCountyVisitedDate(String countyVisitedDate) {
        this.countyVisitedDate = countyVisitedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
