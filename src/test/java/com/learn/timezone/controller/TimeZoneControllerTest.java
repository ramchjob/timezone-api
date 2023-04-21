package com.learn.timezone.controller;

import com.learn.timezone.service.TimeZoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class TimeZoneControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private TimezoneController timezoneController;

    @Mock
    TimeZoneService service;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(timezoneController).build();
    }

    @Test
    public void getAllTimeZones() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/timezone"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllTimeZoneById() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/timezone/Central"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
