package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
