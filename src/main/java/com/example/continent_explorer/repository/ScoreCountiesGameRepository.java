package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.ScoreCountiesGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreCountiesGameRepository extends JpaRepository<ScoreCountiesGame, Long> {
    List<ScoreCountiesGame> findByUserIdAndCountyId(Long userId, Long countyId);
    List<ScoreCountiesGame> findByUserId(Long userId);
    List<ScoreCountiesGame> findByUserIdAndIsFinalAttemptTrue(Long userId);

}
