package com.gps.service;

import com.gps.model.PositionDTO;
import com.gps.model.PositionEntity;
import com.gps.repository.PositionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public PositionDTO save(PositionDTO positionDTO) {
        positionRepository.save(createPositionEntity(positionDTO));
        log.info("Position saved successfully");
        return positionDTO;

    }

    public PositionEntity createPositionEntity(PositionDTO positionDTO) {
        return new PositionEntity(positionDTO.getDeviceId(),
                positionDTO.getLatitiude(),
                positionDTO.getLongitude());
    }


}
