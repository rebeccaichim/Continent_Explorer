package com.example.continent_explorer.controller;

import com.example.continent_explorer.model.County;
import com.example.continent_explorer.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/counties")
public class CountyController {

    @Autowired
    private CountyService countyService;

    @GetMapping("/random")
    public ResponseEntity<County> getRandomCounty() {
        County county = countyService.getRandomCounty();
        return ResponseEntity.ok(county);
    }

    @GetMapping("/all")
    public ResponseEntity<List<County>> getAllCounties() {
        List<County> counties = countyService.getAllCounties();
        return ResponseEntity.ok(counties);
    }


}
