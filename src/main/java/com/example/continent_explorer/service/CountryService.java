package com.example.continent_explorer.service;

import com.example.continent_explorer.model.Country;
import com.example.continent_explorer.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getRandomCountry() {
        List<Country> countries = countryRepository.findAll();
        return countries.get(new Random().nextInt(countries.size()));
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
