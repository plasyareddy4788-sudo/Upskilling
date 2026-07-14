package com.example.slf4j_logging_exercises.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "Lohit";
        int age = 21;

        logger.info("Name : {}", name);

        logger.info("Age : {}", age);

        logger.info("Name : {} Age : {}", name, age);

    }
}