package com.upc.demo.service.impl;

import com.upc.demo.model.BigTree;
import com.upc.demo.repository.BigTreeRepository;
import com.upc.demo.service.BigTreeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BigTreeServiceImpl implements BigTreeService {
    private final BigTreeRepository bigTreeRepository;

    public BigTreeServiceImpl(BigTreeRepository bigTreeRepository) {
        this.bigTreeRepository = bigTreeRepository;
    }

    @Override
    public List<BigTree> listAllBigTrees() {
        return bigTreeRepository.findAll();
    }

    @Override
    public BigTree getBigTree(Long id) {
        return bigTreeRepository.findById(id).orElse(null);
    }

    @Override
    public BigTree create(BigTree bigTree) {
        return bigTreeRepository.save(bigTree);
    }

    @Override
    public boolean delete(Long id) {
        bigTreeRepository.deleteById(id);
        return true;
    }

    @Override
    public BigTree update(BigTree bigTree) {
        Optional<BigTree> optionalBigTree = bigTreeRepository.findById(bigTree.getId());
        if (optionalBigTree.isPresent()) {
            BigTree updateBigTree = optionalBigTree.get();
            updateBigTree.setUsername(bigTree.getUsername());
            updateBigTree.setEmail(bigTree.getEmail());
            updateBigTree.setName(bigTree.getName());
            updateBigTree.setBornAt(bigTree.getBornAt());
            updateBigTree.setGreenLeafs(bigTree.getGreenLeafs());
            bigTreeRepository.save(updateBigTree);
            return updateBigTree;
        }
        return null;
    }
}
