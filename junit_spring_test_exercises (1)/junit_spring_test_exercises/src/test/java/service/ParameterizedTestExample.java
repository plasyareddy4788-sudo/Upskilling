package com.example.junit_spring_test_exercises.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedTestExample {

    CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "5,10,15",
            "10,20,30",
            "100,200,300"
    })
    void testAdd(int a, int b, int expected) {

        assertEquals(expected, service.add(a, b));
    }
}