package com.pawan.dto;

public class Employee {
    private String empName;
    private int empId;
    private Department department;

    public Employee(int empId, String empName, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    public int getEmpId() {
        return this.empId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
