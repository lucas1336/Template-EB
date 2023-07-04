package com.upc.demo.controller;

import com.upc.demo.dto.BigTreeDto;
import com.upc.demo.model.BigTree;
import com.upc.demo.service.BigTreeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class BigTreeController {
    private final BigTreeService bigTreeService;
    private final ModelMapper modelMapper;

    public BigTreeController(BigTreeService bigTreeService, ModelMapper modelMapper) {
        this.bigTreeService = bigTreeService;
        this.modelMapper = modelMapper;
    }

    // URL: http://localhost:8080/api/trees
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<BigTree>> getAllTrees() {
        return new ResponseEntity<List<BigTree>>(bigTreeService.listAllBigTrees(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees
    // Method: POST
    @Transactional
    @PostMapping
    public ResponseEntity<BigTree> createBigTree(@RequestBody BigTreeDto bigTree) {
        return new ResponseEntity<BigTree>(bigTreeService.create(modelMapper.map(bigTree, BigTree.class)), HttpStatus.CREATED);
    }

    // URL: http://localhost:8080/api/trees/{treeId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{treeId}")
    public ResponseEntity<BigTree> deleteBigTree(@PathVariable(name = "treeId") Long treeId) {
        bigTreeService.delete(treeId);
        return new ResponseEntity<BigTree>(HttpStatus.NO_CONTENT);
    }
}
