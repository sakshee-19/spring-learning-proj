package com.udacity.bootstrap.controller;


import com.udacity.bootstrap.controllers.DogController;
import com.udacity.bootstrap.services.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogService dogService;

    @Test
    public void testFindAllDogs() throws Exception{
        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).getAllDogs();
    }

    @Test
    public void testFindAllBreeds() throws Exception{
        mockMvc.perform(get("/dogs/breeds"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).findAllBreeds();
    }

    @Test
    public void testFindAllNames() throws Exception{
        mockMvc.perform(get("/dogs/names"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).findAllName();
    }

    @Test
    public void testFindDogById() throws Exception{
        mockMvc.perform(get("/dogs/1"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).getDogById(Long.valueOf(1));
    }
}
