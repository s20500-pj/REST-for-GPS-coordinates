package com.gps.service;

import com.gps.model.PositionDTO;
import com.gps.model.PositionEntity;
import com.gps.repository.PositionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PositionServiceTestIT {

    @Autowired
    private PositionService positionService;
    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    void setUp() {
        positionRepository.deleteAll();
    }


    @Test
    void shouldSavePosition() {
        PositionEntity positionEntity = positionService.addPosition(new PositionDTO("12345",12345,12345));

        assertThat(positionEntity.getId()).isPositive();
    }

    @Test
    void shouldFindPosition() {
        positionService.addPosition(new PositionDTO("12345",12345,12345));

        assertThat(positionRepository.findById(2L)).isNotEmpty();
    }

}
