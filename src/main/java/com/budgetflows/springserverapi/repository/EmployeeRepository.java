package com.budgetflows.springserverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetflows.springserverapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
