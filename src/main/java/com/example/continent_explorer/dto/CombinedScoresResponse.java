package com.example.continent_explorer.dto;

import com.example.continent_explorer.model.ScoreCountiesGame;
import com.example.continent_explorer.model.ScoreCountriesGame;

import java.util.List;

public class CombinedScoresResponse {
    private List<ScoreCountiesGame> romaniaScores;
    private List<ScoreCountriesGame> europaScores;

    // Constructori, Getteri și Setteri
    public CombinedScoresResponse(List<ScoreCountiesGame> romaniaScores, List<ScoreCountriesGame> europaScores) {
        this.romaniaScores = romaniaScores;
        this.europaScores = europaScores;
    }

    public List<ScoreCountiesGame> getRomaniaScores() {
        return romaniaScores;
    }

    public void setRomaniaScores(List<ScoreCountiesGame> romaniaScores) {
        this.romaniaScores = romaniaScores;
    }

    public List<ScoreCountriesGame> getEuropaScores() {
        return europaScores;
    }

    public void setEuropaScores(List<ScoreCountriesGame> europaScores) {
        this.europaScores = europaScores;
    }
}

