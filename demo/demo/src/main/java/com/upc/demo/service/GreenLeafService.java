package com.upc.demo.service;

import com.upc.demo.model.GreenLeaf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GreenLeafService {
    public abstract List<GreenLeaf> listAllGreenLeafs();
    public abstract List<GreenLeaf> listAllGreenLeafsByBigTreeId(Long bigTreeId);
    public abstract GreenLeaf create(GreenLeaf greenLeaf);
}
