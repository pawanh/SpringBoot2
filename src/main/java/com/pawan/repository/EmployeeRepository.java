package com.pawan.repository;

import com.pawan.entity.DepartmentEntity;
import com.pawan.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

    public List<EmployeeEntity> findByDepartmentEntity(DepartmentEntity departmentEntity);

    @Override
    @EntityGraph(value = "employeesWithDepartment", type = EntityGraph.EntityGraphType.LOAD)
    public Iterable<EmployeeEntity> findAll();
}
