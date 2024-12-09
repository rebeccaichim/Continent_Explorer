package com.example.continent_explorer.controller;

import com.example.continent_explorer.model.Session;
import com.example.continent_explorer.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        Session newSession = sessionService.saveSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSession);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        Optional<Session> session = sessionService.findSessionById(id);
        return session.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

