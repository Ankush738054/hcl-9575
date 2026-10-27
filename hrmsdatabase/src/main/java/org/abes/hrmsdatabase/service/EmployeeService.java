package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createNewEmployee(Employee newEmp){
//        Employee emp1 = new Employee(200l,"Ram","java","Developer","ram@example.com","password123");
        employeeRepository.save(newEmp);
        return "Employee is Added Successfully";
    }
    public Employee getEmployeeById(long emid){
//        System.out.println("Emp Id" + emid);
        return employeeRepository.findById(emid).orElse(null);
    }
    public String deleteEmployeeById(long emid){
        if (employeeRepository.existsById(emid)){
            employeeRepository.deleteById(emid);
        }
        return "Employee Deleted";
    }
    public String updateEmployeeById(long emid){
        Employee emp = employeeRepository.findById(emid).orElse(null);
        if (emp != null){
            Employee emp2 = new Employee(201,"Shyam","java","Developer","shyam@example.com","password123");
            employeeRepository.save(emp2);
        }
        return "Updated";
    }
}
