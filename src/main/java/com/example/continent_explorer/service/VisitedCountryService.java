package com.example.continent_explorer.service;

import com.example.continent_explorer.dto.VisitedCountryRequest;
import com.example.continent_explorer.model.VisitedCountry;
import com.example.continent_explorer.repository.VisitedCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class VisitedCountryService {

    @Autowired
    private VisitedCountryRepository visitedCountryRepository;

    public void saveVisitedCountry(VisitedCountryRequest request) {
        if (request.getVisitedCountryName() == null || request.getVisitedCountryName().isEmpty()) {
            throw new IllegalArgumentException("Visited country name is missing");
        }

        if (request.getContinentId() == null) {
            throw new IllegalArgumentException("Continent ID is missing");
        }

        if (request.getCountryVisitedDate() == null || request.getCountryVisitedDate().isEmpty()) {
            throw new IllegalArgumentException("Visited date is missing or invalid");
        }

        try {
            // Conversie cu format explicit pentru a asigura consistența
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate visitedDate = LocalDate.parse(request.getCountryVisitedDate(), formatter);

            // Crearea obiectului VisitedCountry
            VisitedCountry visitedCountry = new VisitedCountry();
            visitedCountry.setVisitedCountryName(request.getVisitedCountryName());
            visitedCountry.setContinentId(request.getContinentId());
            visitedCountry.setCountryVisitedDate(visitedDate);
            visitedCountry.setUserId(request.getUserId());

            // Salvarea în baza de date
            visitedCountryRepository.save(visitedCountry);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error parsing visited date: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving visited country: " + e.getMessage(), e);
        }
    }

    public List<String> getVisitedCountriesByUser(Long userId) {
        return visitedCountryRepository.findVisitedCountryNamesByUserId(userId);
    }

}
