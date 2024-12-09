package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.ScoreCountiesGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreCountiesGame, Long> {
    @Query("SELECT MAX(s.attemptNumber) FROM ScoreCountiesGame s WHERE s.userId = :userId AND s.countyId = :countyId")
    Optional<Integer> findMaxAttemptNumberByUserIdAndCountyIdRomania(@Param("userId") Long userId, @Param("countyId") Long countyId);

    @Query("SELECT MAX(sc.attemptNumber) FROM ScoreCountriesGame sc WHERE sc.userId = :userId AND sc.countryId = :countryId")
    Optional<Integer> findMaxAttemptNumberByUserIdAndCountryIdEuropa(@Param("userId") Long userId, @Param("countryId") Long countryId);

}
