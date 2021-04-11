package com.app.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.Employee;
import com.app.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@GetMapping(value = "employee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") Integer id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent())
		    return ResponseEntity.ok().body(employee.get());
		return null;
		}
	
	
	@PostMapping(value = "employee")
	public ResponseEntity<String> save(@RequestBody Employee employee){
		employee = employeeRepo.save(employee);
		return ResponseEntity.ok("Employee save with id : " + employee.getId());
	}
	
	@GetMapping(value = "employee")
	public ResponseEntity<List<Employee>> listofEmployee(){
		return ResponseEntity.ok(employeeRepo.findAll());
	}
	
	@DeleteMapping(value = "employee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		employeeRepo.deleteById(id);
		return ResponseEntity.ok("Employee deleted with id : " + id);
	}

	@PutMapping(value = "employee")
	public ResponseEntity<String> update(@RequestBody Employee employee){
		employee = employeeRepo.save(employee);
		return ResponseEntity.ok("Employee updated with id : " + employee.getId());
	}
}
