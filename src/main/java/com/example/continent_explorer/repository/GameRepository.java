package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
