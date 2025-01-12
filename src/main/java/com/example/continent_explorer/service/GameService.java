package com.example.continent_explorer.service;

import com.example.continent_explorer.dto.GuessRequest;
import com.example.continent_explorer.dto.ScoreResponse;
import com.example.continent_explorer.model.Country;
import com.example.continent_explorer.model.County;
import com.example.continent_explorer.model.ScoreCountiesGame;
import com.example.continent_explorer.model.ScoreCountriesGame;
import com.example.continent_explorer.repository.CountryRepository;
import com.example.continent_explorer.repository.CountyRepository;
import com.example.continent_explorer.repository.ScoreCountiesGameRepository;
import com.example.continent_explorer.repository.ScoreCountriesGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    private CountyRepository countyRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ScoreCountiesGameRepository scoreCountiesGameRepository;

    @Autowired
    private ScoreCountriesGameRepository scoreCountriesGameRepository;

    private static final int MAX_ATTEMPTS = 3;
    private static final double[] POINTS_PER_ATTEMPT = {1.0, 0.66, 0.33};

    public County getRandomCountyRomania() {
        List<County> counties = countyRepository.findAll();
        int randomIndex = new Random().nextInt(counties.size());
        return counties.get(randomIndex);
    }

    public ScoreResponse submitGuessRomania(GuessRequest guessRequest) {
        Optional<County> optionalCounty = countyRepository.findById(guessRequest.getCountyId());

        if (!optionalCounty.isPresent()) {
            throw new IllegalArgumentException("Invalid county ID");
        }

        County targetCounty = optionalCounty.get();
        String correctAbbreviation = targetCounty.getCountyAbbreviation();

        List<ScoreCountiesGame> attempts = scoreCountiesGameRepository.findByUserIdAndCountyId(
                guessRequest.getUserId(), guessRequest.getCountyId()
        );

        int attemptNumber = attempts.size() + 1;

        if (attemptNumber > MAX_ATTEMPTS) {
            return new ScoreResponse(0, getTotalScoreRomania(guessRequest.getUserId()), true);
        }

        boolean isCorrectGuess = guessRequest.getGuess().equalsIgnoreCase(correctAbbreviation);

        double pointsAwarded = isCorrectGuess ? POINTS_PER_ATTEMPT[attemptNumber - 1] : 0.0;

        ScoreCountiesGame attempt = new ScoreCountiesGame();
        attempt.setGameId(1L);
        attempt.setUserId(guessRequest.getUserId());
        attempt.setCountyId(guessRequest.getCountyId());
        attempt.setAttemptNumber(attemptNumber);
        attempt.setPointsAwarded(BigDecimal.valueOf(pointsAwarded));
        attempt.setTotalScore(BigDecimal.valueOf(getTotalScoreRomania(guessRequest.getUserId()) + pointsAwarded));
        attempt.setIsFinalAttempt(isCorrectGuess || attemptNumber == MAX_ATTEMPTS);

        scoreCountiesGameRepository.save(attempt);


        return new ScoreResponse(
                MAX_ATTEMPTS - attemptNumber,
                getTotalScoreRomania(guessRequest.getUserId()),
                attempt.getIsFinalAttempt()
        );
    }

    private double getTotalScoreRomania(Long userId) {
        return scoreCountiesGameRepository.findByUserId(userId)
                .stream()
                .mapToDouble(attempt -> attempt.getPointsAwarded().doubleValue())
                .sum();
    }

    public Country getRandomCountryEuropa() {
        List<Country> countries = countryRepository.findAll();
        int randomIndex = new Random().nextInt(countries.size());
        return countries.get(randomIndex);
    }

    public ScoreResponse submitGuessEuropa(GuessRequest guessRequest) {
        Optional<Country> optionalCountry = countryRepository.findById(guessRequest.getCountryId());

        if (!optionalCountry.isPresent()) {
            throw new IllegalArgumentException("Invalid county ID");
        }

        Country targetCountry = optionalCountry.get();
        String correctAbbreviation = targetCountry.getCountryAbbreviation();

        List<ScoreCountriesGame> attempts = scoreCountriesGameRepository.findByUserIdAndCountryId(
                guessRequest.getUserId(), guessRequest.getCountryId()
        );

        int attemptNumber = attempts.size() + 1;

        if (attemptNumber > MAX_ATTEMPTS) {
            return new ScoreResponse(0, getTotalScoreEuropa(guessRequest.getUserId()), true);
        }

        boolean isCorrectGuess = guessRequest.getGuess().equalsIgnoreCase(correctAbbreviation);

        double pointsAwarded = isCorrectGuess ? POINTS_PER_ATTEMPT[attemptNumber - 1] : 0.0;

        ScoreCountriesGame attempt = new ScoreCountriesGame();
        attempt.setGameId(1L);
        attempt.setUserId(guessRequest.getUserId());
        attempt.setCountryId(guessRequest.getCountyId());
        attempt.setAttemptNumber(attemptNumber);
        attempt.setPointsAwarded(BigDecimal.valueOf(pointsAwarded));
        attempt.setTotalScore(BigDecimal.valueOf(getTotalScoreEuropa(guessRequest.getUserId()) + pointsAwarded));
        attempt.setIsFinalAttempt(isCorrectGuess || attemptNumber == MAX_ATTEMPTS);

        scoreCountriesGameRepository.save(attempt);


        return new ScoreResponse(
                MAX_ATTEMPTS - attemptNumber,
                getTotalScoreEuropa(guessRequest.getUserId()),
                attempt.getIsFinalAttempt()
        );
    }

    private double getTotalScoreEuropa(Long userId) {
        return scoreCountriesGameRepository.findByUserId(userId)
                .stream()
                .mapToDouble(attempt -> attempt.getPointsAwarded().doubleValue())
                .sum();
    }
}
