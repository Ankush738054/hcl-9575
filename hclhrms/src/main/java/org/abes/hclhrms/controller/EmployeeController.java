package org.abes.hclhrms.controller;

import org.abes.hclhrms.EmployeeServiceImp;
import org.abes.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;
    @GetMapping("/")
    public String welcomeMsg(){
        return "Welcome to ABES HRMS";
    }
    @GetMapping("/addemp")
    public String addnewEmployee(){
        return employeeServiceImp.addEmp();
    }
    @GetMapping("/getemp")
    public List<Employee> getEmp(){
        return employeeServiceImp.getEmp();
    }
    @GetMapping("/id")
    public Employee getempById(){
        return employeeServiceImp.getEmpId();
    }
    @GetMapping("/bulk")
    public String addEmpBulk(){
        return employeeServiceImp.addEmpBulk();
    }
}
