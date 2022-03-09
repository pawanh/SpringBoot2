package com.pawan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DepartmentEntity {

    private String deptName;

    @Id
    private int deptId;


    public int getDeptId() {
        return this.deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
