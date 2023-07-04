package com.upc.demo.service;

import com.upc.demo.model.BigTree;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BigTreeService {
    public abstract List<BigTree> listAllBigTrees();
    public abstract BigTree getBigTree(Long id);
    public abstract BigTree create(BigTree bigTree);
    public abstract boolean delete(Long id);
    public abstract BigTree update(BigTree bigTree);
}
