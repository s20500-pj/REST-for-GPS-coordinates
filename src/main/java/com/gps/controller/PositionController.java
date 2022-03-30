package com.gps.controller;

import com.gps.model.PositionDTO;
import com.gps.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/save/position/")
    public ResponseEntity<PositionDTO> savePositionDTO(@Valid @RequestBody PositionDTO positionDTO) {
        log.info("Received position");
        return ResponseEntity.ok(positionService.save(positionDTO));

    }

}
