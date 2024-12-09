package com.example.continent_explorer.service;

import com.example.continent_explorer.model.County;
import com.example.continent_explorer.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CountyService {

    @Autowired
    private CountyRepository countyRepository;

    public County getRandomCounty() {
        List<County> counties = countyRepository.findAll();
        return counties.get(new Random().nextInt(counties.size()));
    }

    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }

}
