package com.example.continent_explorer.service;

import com.example.continent_explorer.model.Session;
import com.example.continent_explorer.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    public Optional<Session> findSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId);
    }

}
