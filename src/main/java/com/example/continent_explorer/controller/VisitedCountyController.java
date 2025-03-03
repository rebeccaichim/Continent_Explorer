package com.example.continent_explorer.controller;

import com.example.continent_explorer.dto.VisitedCountyRequest;
import com.example.continent_explorer.service.VisitedCountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/visited-counties")
@CrossOrigin(origins = "*")
public class VisitedCountyController {

    @Autowired
    private VisitedCountyService visitedCountyService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<String> addVisitedCounty(@RequestBody VisitedCountyRequest request) {
        System.out.println("=== Received request in Controller ===");
        System.out.println("Request payload: " + request);

        try {
            visitedCountyService.saveVisitedCounty(request);
            System.out.println("=== Successfully processed request ===");
            return ResponseEntity.ok("County saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving county: " + e.getMessage());
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<String>> getFormattedVisitedCounties(@PathVariable Long userId) {
        List<String> formattedCounties = visitedCountyService.getVisitedCountiesByUser(userId)
                .stream()
                .map(vc -> vc.getVisitedCountyName() + " (" + vc.getCountyVisitedDate() + ")")
                .collect(Collectors.toList());
        return ResponseEntity.ok(formattedCounties);
    }


}
