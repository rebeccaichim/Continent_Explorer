package com.example.continent_explorer.controller;

import com.example.continent_explorer.dto.GuessRequest;
import com.example.continent_explorer.dto.ScoreResponse;
import com.example.continent_explorer.model.Country;
import com.example.continent_explorer.model.County;
import com.example.continent_explorer.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/random-county-romania")
    public ResponseEntity<County> getRandomCountyRomania() {
        County county = gameService.getRandomCountyRomania();
        return ResponseEntity.ok(county);
    }

    @PostMapping("/submit-guess-romania")
    public ResponseEntity<ScoreResponse> submitGuessRomania(@RequestBody GuessRequest guessRequest) {
        ScoreResponse response = gameService.submitGuessRomania(guessRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/random-county-europa")
    public ResponseEntity<Country> getRandomCountyEuropa() {
        Country country = gameService.getRandomCountryEuropa();
        return ResponseEntity.ok(country);
    }

    @PostMapping("/submit-guess-europa")
    public ResponseEntity<ScoreResponse> submitGuessEuropa(@RequestBody GuessRequest guessRequest) {
        ScoreResponse response = gameService.submitGuessEuropa(guessRequest);
        return ResponseEntity.ok(response);
    }
}
