package org.example.slexpresssdn.repository;


import org.example.slexpresssdn.dto.TransportLineNodeDTO;
import org.example.slexpresssdn.entity.node.AgencyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransportLineRepositoryTest {

    @Resource
    private TransportLineRepository transportLineRepository;

    @Test
    void findShortestPath() {
        AgencyEntity start = AgencyEntity.builder().bid(100280L).build();
        AgencyEntity end = AgencyEntity.builder().bid(210057L).build();
        TransportLineNodeDTO transportLineNodeDTO = this.transportLineRepository.findShortestPath(start, end);
        System.out.println(transportLineNodeDTO);
    }
}