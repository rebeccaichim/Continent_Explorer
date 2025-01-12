package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.VisitedCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitedCountryRepository extends JpaRepository<VisitedCountry, Long> {
    List<VisitedCountry> findByUserId(Long userId);
}
