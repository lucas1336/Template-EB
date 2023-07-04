package com.upc.demo.controller;

import com.upc.demo.model.Score;
import com.upc.demo.service.ScoreService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Driver;

@RestController
@RequestMapping("/api/v1/drivers")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    // URL: http://localhost:8080/api/v1/drivers/{driverId}/scores
    // Method: GET

    // URL: http://localhost:8080/api/v1/drivers
    // Method: POST
    @Transactional
    @PostMapping
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        return new ResponseEntity<Score>(scoreService.create(score), HttpStatus.CREATED);
    }
}
