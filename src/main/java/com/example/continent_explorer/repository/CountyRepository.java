package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.County;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyRepository extends JpaRepository<County, Long> {
}
