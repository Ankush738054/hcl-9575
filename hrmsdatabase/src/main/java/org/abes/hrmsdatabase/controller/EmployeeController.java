package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/v1/user")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String msg(){
        return "Heloooooooooooooooo Brooooooooooooooooo";
    }
    @PostMapping("/addemp")
    public String addNewEmp(@RequestBody Employee emp){
        System.out.println(emp.getEmail());
        return employeeService.createNewEmployee(emp);
    }
    @PostMapping("/login")
    public String login(@RequestBody Employee employee) {
        return employeeService.verification(
                employee.getEmp_id(),
                employee.getPassword()
        );
    }
    @GetMapping("/findbyid/{empid}")
    public Employee getEmpById(@PathVariable long empid){
        System.out.println(empid);
        return employeeService.getEmployeeById(empid);
    }
    @GetMapping("/deletebyid/{empid}")
    public String deleteEmpById(@PathVariable long empid){
        return employeeService.deleteEmployeeById(empid);
    }

    @PutMapping("/updateid/{empid}")
    public String updateid(@PathVariable long empid) {
        return employeeService.updateEmployeeById(empid);
    }

}
