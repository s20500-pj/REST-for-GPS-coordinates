package com.gps.controller;

import com.gps.repository.PositionRepository;
import com.gps.service.PositionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PositionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PositionService positionService;
    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    void setUp() {
        positionRepository.deleteAll();
    }

    @Test
    void shouldAddPositionDTO() throws Exception {
        mockMvc.perform(post("/save/position/").contentType(MediaType.APPLICATION_JSON_VALUE).content("{'deviceId':'12345', 'latitiude': 12345, 'longitude': 12345}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.positionTime", notNullValue()))
                .andExpect(jsonPath("$.deviceId",containsString("12345")))
                .andExpect(jsonPath("$.latitiude",notNullValue()))
                .andExpect(jsonPath("$.longitude",notNullValue()));
    }

    @Test
    void willThrowErrorWhenParametersAreInvalid() throws Exception{
        mockMvc.perform(post("/save/position/").contentType(MediaType.APPLICATION_JSON_VALUE).content("{'latitiude': 1, 'longitude': 111111}"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp", notNullValue()))
                .andExpect(jsonPath("$.errors[0]",containsString("attribute can't be empty")));

    }

}