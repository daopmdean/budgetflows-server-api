package com.budgetflows.springserverapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetflows.springserverapi.entity.Employee;
import com.budgetflows.springserverapi.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> getEmployees() {
		return repo.findAll();
	}
	
	public Employee getEmployee(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
