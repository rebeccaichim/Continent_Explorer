package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
