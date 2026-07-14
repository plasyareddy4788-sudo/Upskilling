package com.example.slf4j_logging_exercises.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger =
            LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {

        logger.info("Application Started");

        logger.warn("This is a warning");

        logger.error("This is an error");

    }
}