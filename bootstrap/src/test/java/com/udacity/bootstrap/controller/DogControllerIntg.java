package com.udacity.bootstrap.controller;

import com.udacity.bootstrap.entities.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntg {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFindALlDogs() {
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:"+port+"/dogs", List.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testFindALlBreed() {
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:"+port+"/dogs/breeds", List.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testFindALlName() {
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:"+port+"/dogs/names", List.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testFindDog() {
        ResponseEntity<Dog> responseEntity = testRestTemplate.getForEntity("http://localhost:"+port+"/dogs/1", Dog.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
