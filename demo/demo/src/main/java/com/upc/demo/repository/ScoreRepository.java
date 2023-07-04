package com.upc.demo.repository;

import com.upc.demo.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT AVG(s.value) FROM Score s WHERE s.driverId = :driverId")
    Float getAverageScore(@Param("driverId") Long driverId);
    @Query("SELECT MAX(s.value) FROM Score s WHERE s.driverId = :driverId")
    Integer getMaxScore(@Param("driverId") Long driverId);
}
