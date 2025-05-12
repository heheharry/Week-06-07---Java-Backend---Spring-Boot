package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {

    @Autowired
    private DepartmentBean departmentBean; 

    public String getEmployeeName() {
        return "Heheharry";
    }

    public String getEmployeeDetails() {
        return getEmployeeName() + " - " + departmentBean.getDepartmentName();
    }
}
