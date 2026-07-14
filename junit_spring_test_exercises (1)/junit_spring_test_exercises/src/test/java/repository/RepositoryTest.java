package com.example.junit_spring_test_exercises.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.junit_spring_test_exercises.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testFindByName() {

        repository.save(new User(1L, "Lohit"));
        repository.save(new User(2L, "Ravi"));

        List<User> users = repository.findByName("Lohit");

        assertEquals(1, users.size());
        assertEquals("Lohit", users.get(0).getName());
    }
}