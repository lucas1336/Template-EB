package com.upc.demo.service.impl;

import com.upc.demo.model.GreenLeaf;
import com.upc.demo.repository.GreenLeafRepository;
import com.upc.demo.service.GreenLeafService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenLeafServiceImpl implements GreenLeafService {
    private final GreenLeafRepository greenLeafRepository;

    public GreenLeafServiceImpl(GreenLeafRepository greenLeafRepository) {
        this.greenLeafRepository = greenLeafRepository;
    }

    @Override
    public List<GreenLeaf> listAllGreenLeafs() {
        return greenLeafRepository.findAll();
    }

    @Override
    public List<GreenLeaf> listAllGreenLeafsByBigTreeId(Long bigTreeId) {
        return greenLeafRepository.findByBigTreeId(bigTreeId);
    }

    @Override
    public GreenLeaf create(GreenLeaf greenLeaf) {
        return greenLeafRepository.save(greenLeaf);
    }
}