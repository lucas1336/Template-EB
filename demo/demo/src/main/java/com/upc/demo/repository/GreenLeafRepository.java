package com.upc.demo.repository;

import com.upc.demo.model.GreenLeaf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreenLeafRepository extends JpaRepository<GreenLeaf, Long> {
    List<GreenLeaf> findByBigTreeId(long bigTreeId);
}
