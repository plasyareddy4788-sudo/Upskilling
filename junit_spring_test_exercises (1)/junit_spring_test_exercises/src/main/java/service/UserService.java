package com.example.junit_spring_test_exercises.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.junit_spring_test_exercises.entity.User;
import com.example.junit_spring_test_exercises.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUserById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("User not found"));
    }

    public User saveUser(User user) {

        return repository.save(user);

    }

}