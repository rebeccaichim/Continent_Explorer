package com.example.continent_explorer.service;

import com.example.continent_explorer.model.ScoreCountiesGame;
import com.example.continent_explorer.dto.ScoreRequest;
import com.example.continent_explorer.model.ScoreCountriesGame;
import com.example.continent_explorer.repository.ScoreCountiesGameRepository;
import com.example.continent_explorer.repository.ScoreCountriesGameRepository;
import com.example.continent_explorer.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ScoreCountiesGameRepository scoreCountiesGameRepository;
    @Autowired
    private ScoreCountriesGameRepository scoreCountriesGameRepository;


    public void saveScoreRomania(ScoreRequest scoreRequest) {
        int attemptNumberRomania = determineAttemptNumberRomania(scoreRequest.getUserId(), scoreRequest.getCountyId());

        ScoreCountiesGame score = new ScoreCountiesGame();
        score.setUserId(scoreRequest.getUserId());
        score.setGameId(scoreRequest.getGameId());
        score.setCountyId(scoreRequest.getCountyId());
        score.setAttemptNumber(attemptNumberRomania);


        score.setPointsAwarded(BigDecimal.valueOf(scoreRequest.getPointsAwarded()));
        score.setTotalScore(BigDecimal.valueOf(scoreRequest.getTotalScore()));

        score.setIsFinalAttempt(scoreRequest.getIsFinalAttempt());
        score.setAttemptTime(Timestamp.from(Instant.now()));

        scoreRepository.save(score);
    }



    public int determineAttemptNumberRomania(Long userId, Long countyId) {
        Optional<Integer> maxAttempt = scoreRepository.findMaxAttemptNumberByUserIdAndCountyIdRomania(userId, countyId);

        return maxAttempt.map(attempt -> attempt + 1).orElse(1);
    }

    public int determineAttemptNumberEuropa(Long userId, Long countryId) {
        Optional<Integer> maxAttempt = scoreRepository.findMaxAttemptNumberByUserIdAndCountryIdEuropa(userId, countryId);

        return maxAttempt.map(attempt -> attempt + 1).orElse(1);
    }


    public void saveScoreEuropa(ScoreRequest scoreRequest) {
        int attemptNumber = determineAttemptNumberEuropa(scoreRequest.getUserId(), scoreRequest.getCountryId());

        ScoreCountriesGame score = new ScoreCountriesGame();
        score.setUserId(scoreRequest.getUserId());
        score.setGameId(scoreRequest.getGameId());
        score.setCountryId(scoreRequest.getCountryId());
        score.setAttemptNumber(attemptNumber);


        score.setPointsAwarded(BigDecimal.valueOf(scoreRequest.getPointsAwarded()));
        score.setTotalScore(BigDecimal.valueOf(scoreRequest.getTotalScore()));

        score.setIsFinalAttempt(scoreRequest.getIsFinalAttempt());

        score.setAttemptTime(Timestamp.from(Instant.now()));
        scoreCountriesGameRepository.save(score);
    }


    public List<ScoreCountiesGame> getScoresForRomania(Long userId) {
        return scoreCountiesGameRepository.findByUserIdAndIsFinalAttemptTrue(userId);
    }

    public List<ScoreCountriesGame> getScoresForEuropa(Long userId) {
        return scoreCountriesGameRepository.findByUserIdAndIsFinalAttemptTrue(userId);
    }
}


