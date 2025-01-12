package com.example.continent_explorer.service;

import com.example.continent_explorer.dto.VisitedCountyRequest;
import com.example.continent_explorer.model.VisitedCounty;
import com.example.continent_explorer.repository.VisitedCountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class VisitedCountyService {

    @Autowired
    private VisitedCountyRepository visitedCountyRepository;

    public void saveVisitedCounty(VisitedCountyRequest request) {
        if (request.getVisitedCountyName() == null || request.getVisitedCountyName().isEmpty()) {
            throw new IllegalArgumentException("Visited county name is missing");
        }

        if (request.getCountryId() == null) {
            throw new IllegalArgumentException("Country ID is missing");
        }

        if (request.getCountyVisitedDate() == null || request.getCountyVisitedDate().isEmpty()) {
            throw new IllegalArgumentException("Visited date is missing or invalid");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate visitedDate = LocalDate.parse(request.getCountyVisitedDate(), formatter);

            VisitedCounty visitedCounty = new VisitedCounty();
            visitedCounty.setVisitedCountyName(request.getVisitedCountyName());
            visitedCounty.setCountryId(request.getCountryId());
            visitedCounty.setCountyVisitedDate(visitedDate);
            visitedCounty.setUserId(request.getUserId());

            visitedCountyRepository.save(visitedCounty);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error parsing visited date: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving visited county: " + e.getMessage(), e);
        }
    }

    public List<VisitedCounty> getVisitedCountiesByUser(Long userId) {
        return visitedCountyRepository.findByUserId(userId);
    }


}
