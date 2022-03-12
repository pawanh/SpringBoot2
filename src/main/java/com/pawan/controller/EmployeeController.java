package com.pawan.controller;

import com.pawan.dto.Department;
import com.pawan.dto.Employee;
import com.pawan.service.DepartmentService;
import com.pawan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "department/{departmentId}/employees")
    public List<Employee> getEmployeesByDept(@PathVariable Integer departmentId) {
        return employeeService.getAllEmployeesByDepartment(departmentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "department/{departmentId}/employees")
    public Employee addEmployee(@RequestBody Employee employee, @PathVariable Integer departmentId) {
        Department department = departmentService.getDepartment(departmentId);
        employee.setDepartment(department);
        return employeeService.add(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        return employeeService.update(id, employee);
    }

}
