package com.example.continent_explorer.dto;

public class ScoreRequest {
    private Long userId;
    private Long gameId;
    private Long countyId;
    private Long countryId;
    private int attemptNumber;
    private double pointsAwarded;
    private double totalScore;
    private Boolean isFinalAttempt;
    private Long attemptTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public double getPointsAwarded() {
        return pointsAwarded;
    }

    public void setPointsAwarded(double pointsAwarded) {
        this.pointsAwarded = pointsAwarded;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public Boolean getIsFinalAttempt() {
        return isFinalAttempt;
    }

    public void setFinalAttempt(Boolean finalAttempt) {
        isFinalAttempt = finalAttempt;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(Long attemptTime) {
        this.attemptTime = attemptTime;
    }
}
