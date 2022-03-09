package com.pawan.repository;

import com.pawan.entity.DepartmentEntity;
import com.pawan.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer> {
}
