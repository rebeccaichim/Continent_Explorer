package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.ScoreCountiesGame;
import com.example.continent_explorer.model.VisitedCounty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitedCountyRepository extends JpaRepository<VisitedCounty, Long> {
    List<VisitedCounty> findByUserId(Long userId);

    @Query("SELECT v.visitedCountyName FROM VisitedCounty v WHERE v.userId = :userId")
    List<String> findVisitedCountyNamesByUserId(@Param("userId") Long userId);


}
