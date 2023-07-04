package com.upc.demo.controller;

import com.upc.demo.dto.GreenLeafDto;
import com.upc.demo.model.BigTree;
import com.upc.demo.model.GreenLeaf;
import com.upc.demo.service.BigTreeService;
import com.upc.demo.service.GreenLeafService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class GreenLeafController {
    private final GreenLeafService greenLeafService;
    private final BigTreeService bigTreeService;
    private final ModelMapper modelMapper;

    public GreenLeafController(GreenLeafService greenLeafService, BigTreeService bigTreeService, ModelMapper modelMapper) {
        this.greenLeafService = greenLeafService;
        this.bigTreeService = bigTreeService;
        this.modelMapper = modelMapper;
    }

    // URL: http://localhost:8080/api/trees/{treeId}/leafs
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/leafs")
    public ResponseEntity<List<GreenLeaf>> getLeafsByTreeId() {
        return new ResponseEntity<List<GreenLeaf>>(greenLeafService.listAllGreenLeafs(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees/{treeId}/leafs
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{treeId}/leafs")
    public ResponseEntity<List<GreenLeaf>> getLeafsByTreeId(@PathVariable(name = "treeId") Long treeId) {
        return new ResponseEntity<List<GreenLeaf>>(greenLeafService.listAllGreenLeafsByBigTreeId(treeId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/trees/{treeId}/leafs/
    // Method: POST
    @Transactional
    @PostMapping("/{treeId}/leafs")
    public ResponseEntity<GreenLeaf> createGreenLeaf(@PathVariable(name = "treeId") Long treeId, @RequestBody GreenLeafDto greenLeaf) {
        GreenLeaf greenLeaf1 = modelMapper.map(greenLeaf, GreenLeaf.class);
        BigTree bigTree = bigTreeService.getBigTree(treeId);
        greenLeaf1.setBigTree(bigTree);
        return new ResponseEntity<GreenLeaf>(greenLeafService.create(greenLeaf1), HttpStatus.CREATED);
    }
}
