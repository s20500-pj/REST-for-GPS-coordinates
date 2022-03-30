package com.gps.service;


import com.gps.model.PositionDTO;
import com.gps.model.PositionEntity;
import com.gps.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PositionServiceTest {

    @InjectMocks
    private PositionService positionService;
    @Mock
    private PositionRepository positionRepository;


    @Test
    void canSavePosition(){
        //Given
        PositionDTO positionDTO= new PositionDTO("12345",12345.0,12345.0);
        //When
        PositionDTO positionDTO1 = positionService.save(new PositionDTO("12345",12345.0,12345.0));
        //Then
        assertThat(positionDTO1.getDeviceId()).isEqualTo("12345");
    }
    @Test
    void canAddPosition(){
        //given
        PositionDTO positionDTO= new PositionDTO("12345",12345.0,12345.0);
        //when
        positionService.save(positionDTO);
        //then
        ArgumentCaptor<PositionEntity> positionEntityArgumentCaptor = ArgumentCaptor.forClass(PositionEntity.class);

        verify(positionRepository).save(positionEntityArgumentCaptor.capture());

        PositionEntity capturedPositionEntity = positionEntityArgumentCaptor.getValue();

        assertThat(capturedPositionEntity.getDeviceId()).isEqualTo(positionService.createPositionEntity(positionDTO).getDeviceId());
    }
    @Test
    void canCreatePositionEntityFromPositionDTO(){
        //given
        PositionDTO positionDTO = new PositionDTO("12345",12345.0,12345.0);
        //when
        PositionEntity positionEntity = positionService.createPositionEntity(positionDTO);
        //then
        assertThat(positionEntity.getDeviceId()).isEqualTo("12345");
    }



}