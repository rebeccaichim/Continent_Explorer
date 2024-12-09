package com.example.continent_explorer.service;

import com.example.continent_explorer.model.Continent;
import com.example.continent_explorer.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

}
