package com.example.continent_explorer.repository;

import com.example.continent_explorer.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
