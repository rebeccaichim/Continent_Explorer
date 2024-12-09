package com.example.continent_explorer.dto;

public class ScoreResponse {
    private int attemptsLeft;
    private double totalScore;
    private boolean isGameOver;

    public ScoreResponse(int attemptsLeft, double totalScore, boolean isGameOver) {
        this.attemptsLeft = attemptsLeft;
        this.totalScore = totalScore;
        this.isGameOver = isGameOver;


    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}