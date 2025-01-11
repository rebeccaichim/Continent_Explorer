package com.example.continent_explorer.controller;

import com.example.continent_explorer.dto.VisitedCountryRequest;
import com.example.continent_explorer.service.VisitedCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/visited-countries")
@CrossOrigin(origins = "*")
public class VisitedCountryController {

    @Autowired
    private VisitedCountryService visitedCountryService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<String> addVisitedCountry(@RequestBody VisitedCountryRequest request) {
        System.out.println("=== Received request in Controller ===");
        System.out.println("Request payload: " + request);

        try {
            visitedCountryService.saveVisitedCountry(request);
            System.out.println("=== Successfully processed request ===");
            return ResponseEntity.ok("Country saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving country: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<String>> getVisitedCountries(@PathVariable Long userId) {
        List<String> visitedCountries = visitedCountryService.getVisitedCountriesByUser(userId);
        return ResponseEntity.ok(visitedCountries != null ? visitedCountries : new ArrayList<>());
    }
}
