package com.example.continent_explorer.controller;

import com.example.continent_explorer.dto.CombinedScoresResponse;
import com.example.continent_explorer.dto.ScoreRequest;
import com.example.continent_explorer.model.ScoreCountiesGame;
import com.example.continent_explorer.model.ScoreCountriesGame;
import com.example.continent_explorer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/romania/{userId}")
    public ResponseEntity<List<ScoreCountiesGame>> getScoresRomania(@PathVariable Long userId) {
        List<ScoreCountiesGame> scores = scoreService.getScoresForRomania(userId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/europa/{userId}")
    public ResponseEntity<List<ScoreCountriesGame>> getScoresEuropa(@PathVariable Long userId) {
        List<ScoreCountriesGame> scores = scoreService.getScoresForEuropa(userId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CombinedScoresResponse> getAllScores(@PathVariable Long userId) {
        List<ScoreCountiesGame> romaniaScores = scoreService.getScoresForRomania(userId);
        List<ScoreCountriesGame> europaScores = scoreService.getScoresForEuropa(userId);

        CombinedScoresResponse response = new CombinedScoresResponse(romaniaScores, europaScores);
        return ResponseEntity.ok(response);
    }


}



