package com.upc.demo.service.impl;

import com.upc.demo.model.Score;
import com.upc.demo.repository.ScoreRepository;
import com.upc.demo.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score create(Score score) {
        score.setRegisteredAt(Date.from(java.time.Instant.now()));
        return scoreRepository.save(score);
    }

    @Override
    public Float getAverageScore(Long driverId) {
        return scoreRepository.getAverageScore(driverId);
    }

    @Override
    public Integer getMaxScore(Long driverId) {
        return scoreRepository.getMaxScore(driverId);
    }
}
