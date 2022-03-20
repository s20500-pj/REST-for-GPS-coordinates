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

    public PositionEntity save(PositionEntity positionEntity) {
        try {
            return positionRepository.save(positionEntity);
        } finally {
            log.info("Position saved successfully");
        }

    }

    public PositionEntity addPosition(PositionDTO positionDTO) {
        return save(createPositionEntity(positionDTO));
    }

    public PositionEntity createPositionEntity(PositionDTO positionDTO) {
        return new PositionEntity(positionDTO.getDeviceId(),
                positionDTO.getLatitiude(),
                positionDTO.getLongitude());
    }


}
