package com.pawan.service;

import com.pawan.dto.Department;
import com.pawan.entity.DepartmentEntity;
import com.pawan.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;



    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();

        departmentRepository.findAll().forEach(
                (entity) -> {
                    Department department = new Department(entity.getDeptId(), entity.getDeptName());
                    departments.add(department);
                }
        );
        return departments;
    }

    public Department getDepartment(int departmentId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        return new Department(departmentEntity.get().getDeptId(), departmentEntity.get().getDeptName());
    }

    public Department add(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDeptId(department.getDeptId());
        departmentEntity.setDeptName(department.getDeptName());

        departmentEntity = departmentRepository.save(departmentEntity);

        if (departmentEntity!=null)
            return department;
        else return null;
    }
}
