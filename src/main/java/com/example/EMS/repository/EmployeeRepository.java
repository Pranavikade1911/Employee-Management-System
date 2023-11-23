package com.example.EMS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.EMS.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}