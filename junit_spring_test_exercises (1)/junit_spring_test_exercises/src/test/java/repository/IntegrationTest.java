package com.example.junit_spring_test_exercises.repository;

import com.example.junit_spring_test_exercises.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserRepository repository;

    @Test
    void integrationTest() {

        repository.save(new User(1L, "Lohit"));

        String response =
                restTemplate.getForObject(
                        "http://localhost:" + port + "/users/1",
                        String.class);

        System.out.println(response);

    }
}