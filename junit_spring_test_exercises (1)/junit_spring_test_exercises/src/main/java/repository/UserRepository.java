package com.example.junit_spring_test_exercises.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.junit_spring_test_exercises.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

}