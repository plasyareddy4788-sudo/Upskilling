package com.example.junit_spring_test_exercises.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.junit_spring_test_exercises.entity.User;
import com.example.junit_spring_test_exercises.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void testGetUserById() {

        User user = new User(1L, "Lohit");

        when(repository.findById(1L))
                .thenReturn(Optional.of(user));

        User result = service.getUserById(1L);

        assertEquals("Lohit", result.getName());

    }
}