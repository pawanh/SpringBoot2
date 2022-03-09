package com.pawan.controller;

import com.pawan.dto.Department;
import com.pawan.dto.Employee;
import com.pawan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/departments")
    public List<Department> getEmployees() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/departments")
    public Department addEmployee(@RequestBody Department department) {
        return departmentService.add(department);
    }

}
