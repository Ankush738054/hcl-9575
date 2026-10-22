package org.abes.hclhrms.repository;

import org.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {
    String addemp(Employee emp);
    List<Employee> getEmp();
    Employee getEmpById(long empid);
    String deleteById(long empid);
    String updateById(long empid,Employee updatedEmp);
}
