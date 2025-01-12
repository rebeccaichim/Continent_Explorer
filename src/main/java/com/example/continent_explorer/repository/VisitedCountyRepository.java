package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.VisitedCounty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitedCountyRepository extends JpaRepository<VisitedCounty, Long> {
    List<VisitedCounty> findByUserId(Long userId);

}
