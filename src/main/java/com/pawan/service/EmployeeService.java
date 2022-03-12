package com.pawan.service;

import com.pawan.dto.Department;
import com.pawan.dto.Employee;
import com.pawan.entity.DepartmentEntity;
import com.pawan.entity.EmployeeEntity;
import com.pawan.repository.DepartmentRepository;
import com.pawan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployeesByDepartment(Integer departmentId) {
        List<Employee> employeesByDepartment = new ArrayList<>();
        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        employeeRepository.findByDepartmentEntity(department.get()).forEach(
                employeeEntity -> {
                    Department department1= new Department(employeeEntity.getDepartmentEntity().getDeptId(),employeeEntity.getDepartmentEntity().getDeptName());
                    Employee employee = new Employee(employeeEntity.getEmpId(), employeeEntity.getEmpName(), department1);
                    employeesByDepartment.add(employee);
                }
        );
        return employeesByDepartment;

    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        employeeRepository.findAll().forEach(
                (entity) -> {
                    Department department = new Department(entity.getDepartmentEntity().getDeptId(), entity.getDepartmentEntity().getDeptName());
                    Employee employee = new Employee(entity.getEmpId(), entity.getEmpName(), department);
                    employees.add(employee);
                }
        );
        return employees;
    }

    public Employee add(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(employee.getEmpId());
        employeeEntity.setEmpName(employee.getEmpName());

        Optional<DepartmentEntity> department = departmentRepository.findById(employee.getDepartment().getDeptId());

        employeeEntity.setDepartmentEntity(department.get());

        employeeRepository.save(employeeEntity);

        return employee;
    }

    public Employee update(int id, Employee employee) {
        Optional<EmployeeEntity> toUpdate = employeeRepository.findById(id);
        toUpdate.get().setEmpName(employee.getEmpName());

        employeeRepository.save(toUpdate.get());

        return employee;

    }
}
