package com.example.continent_explorer.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "score_countries_game")
public class ScoreCountriesGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attemptId;

    private Long gameId;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    private Long countryId;
    private int attemptNumber;
    private BigDecimal pointsAwarded;
    private BigDecimal totalScore;
    private boolean isFinalAttempt;
    private Timestamp attemptTime;



    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCountyId() {
        return countryId;
    }

    public void setCountryId(Long countyId) {
        this.countryId = countyId;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public BigDecimal getPointsAwarded() {
        return pointsAwarded;
    }

    public void setPointsAwarded(BigDecimal pointsAwarded) {
        this.pointsAwarded = pointsAwarded;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public boolean getIsFinalAttempt() {
        return isFinalAttempt;
    }

    public void setIsFinalAttempt(boolean isFinalAttempt) {
        this.isFinalAttempt = isFinalAttempt;
    }

    public boolean isFinalAttempt() {
        return isFinalAttempt;
    }

    public void setFinalAttempt(boolean finalAttempt) {
        isFinalAttempt = finalAttempt;
    }

    public Timestamp getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(Timestamp attemptTime) {
        this.attemptTime = attemptTime;
    }
}
