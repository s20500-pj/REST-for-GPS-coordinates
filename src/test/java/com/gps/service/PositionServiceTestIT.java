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
    void shouldFindPosition() {
        positionService.save(new PositionDTO("12345",12345.0,12345.0));

        assertThat(positionRepository.findById(2L)).isNotEmpty();
    }
    @Test
    void shouldSavePosition(){
        PositionDTO positionDTO = positionService.save(new PositionDTO("12345",12345.0,12345.0));
        assertThat(positionDTO.getLongitude()).isPositive();
    }

}
