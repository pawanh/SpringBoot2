package com.pawan.entity;

import javax.persistence.*;

@Entity
@NamedEntityGraph(name = "employeesWithDepartment",attributeNodes = @NamedAttributeNode("departmentEntity"))
public class EmployeeEntity {

    private String empName;

    @Id
    private int empId;

    @ManyToOne
    public DepartmentEntity departmentEntity;


    public int getEmpId() {
        return this.empId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }
}
