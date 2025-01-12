package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.ScoreCountriesGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreCountriesGameRepository extends JpaRepository<ScoreCountriesGame, Long> {
    List<ScoreCountriesGame> findByUserIdAndCountryId(Long userId, Long countryId);
    List<ScoreCountriesGame> findByUserId(Long userId);
    List<ScoreCountriesGame> findByUserIdAndIsFinalAttemptTrue(Long userId);

}
