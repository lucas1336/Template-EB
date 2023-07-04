package com.upc.demo.repository;

import com.upc.demo.model.BigTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigTreeRepository extends JpaRepository<BigTree, Long> {
    List<BigTree> findAll();
}
