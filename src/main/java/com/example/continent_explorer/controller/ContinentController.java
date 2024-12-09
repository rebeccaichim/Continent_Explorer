package com.example.continent_explorer.controller;

import com.example.continent_explorer.model.Continent;
import com.example.continent_explorer.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }
}
