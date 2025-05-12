package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private EmployeeBean employeeBean;

    @GetMapping("/emp")
    public String getName() {
        logger.info("Inside getName() method");
        String details = employeeBean.getEmployeeDetails();
        logger.debug("Employee Details: {}", details);
        return "Employee Details: " + details;
    }
}
