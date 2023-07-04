package com.upc.demo.service;

import com.upc.demo.model.Score;
import org.springframework.stereotype.Service;

@Service
public interface ScoreService {
    public abstract Score create(Score score);
    public abstract Float getAverageScore(Long driverId);
    public abstract Integer getMaxScore(Long driverId);
}
