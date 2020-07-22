package com.budgetflows.springserverapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetflows.springserverapi.entity.Employee;
import com.budgetflows.springserverapi.service.EmployeeService;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return service.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return service.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee epml) {
		return service.saveEmployee(epml);
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}
	
	@DeleteMapping("employees/{id}") 
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	
}
