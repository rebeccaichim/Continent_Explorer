package com.example.continent_explorer.controller;


import com.example.continent_explorer.model.Country;
import com.example.continent_explorer.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/random")
    public ResponseEntity<Country> getRandomCountry() {
        Country country = countryService.getRandomCountry();
        return ResponseEntity.ok(country);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
}
