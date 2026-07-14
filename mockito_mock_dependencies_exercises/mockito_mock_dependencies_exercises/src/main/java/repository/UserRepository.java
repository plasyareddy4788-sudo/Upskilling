package com.example.mockito_mock_dependencies_exercises.repository;

import com.example.mockito_mock_dependencies_exercises.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}