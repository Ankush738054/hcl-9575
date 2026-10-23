package org.abes.hclhrms;

import org.abes.hclhrms.entity.Employee;
import org.abes.hclhrms.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmployeeRepo emprepo;

    public String addEmp(){
        Employee emp1 = new Employee(200l, "Abhay", "FSD", "Java","abhay123@gmail.com");
        return emprepo.addemp(emp1);
    }
    public List<Employee> getEmp(){
        return emprepo.getEmp();
    }
    public Employee getEmpId(){
        return emprepo.getEmpById(200);
    }
    public String addEmpBulk(){
        return emprepo.addEmpbulk();
    }

}
