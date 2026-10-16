package org.example.HRMS;

public class Employee {
    private Address address;
    private Department department;
    public Employee(Address address, Department department){
        this.address = address;
        this.department = department;
    }
    public void getEmpAddress(){
        address.getAddress();
    }
    public void getDepartment(){
        department.getDepartment();
    }
}
