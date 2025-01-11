package com.example.continent_explorer.controller;

import com.example.continent_explorer.dto.ScoreRequest;
import com.example.continent_explorer.model.ScoreCountiesGame;
import com.example.continent_explorer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/saveRomania")
    public ResponseEntity<String> saveScoreRomania(@RequestBody ScoreRequest scoreRequest) {
        System.out.println("Received score: " + scoreRequest);
        scoreService.saveScoreRomania(scoreRequest);
        return ResponseEntity.ok("Score saved successfully");
    }

    @PostMapping("/saveEuropa")
    public ResponseEntity<String> saveScoreEuropa(@RequestBody ScoreRequest scoreRequest) {
        System.out.println("Received isFinalAttempt: " + scoreRequest.getIsFinalAttempt());
        System.out.println("Received score: " + scoreRequest);
        scoreService.saveScoreEuropa(scoreRequest);
        return ResponseEntity.ok("Score saved successfully");
    }

}



