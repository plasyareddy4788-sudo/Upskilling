package com.cognizant.api_gateway.filter;

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.stereotype.Component;

@Component
public class LogFilter {

    public LogFilter() {
        System.out.println("Global Log Filter Loaded Successfully");
    }
}