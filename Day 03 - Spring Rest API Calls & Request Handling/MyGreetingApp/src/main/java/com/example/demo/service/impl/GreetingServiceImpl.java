package com.example.demo.service.impl;

import com.example.demo.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    public String getGreeting() {
        return "Hello World from Service";
    }
}