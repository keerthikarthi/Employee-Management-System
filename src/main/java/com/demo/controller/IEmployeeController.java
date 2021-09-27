package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Employee;
import com.demo.service.IEmployeeService;


@RestController
@RequestMapping("/employee")
public class IEmployeeController {
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("/{userId}")
	public Employee getEmployeeById(@PathVariable("userId") int userId)
	{
		
		return empService.getEmployeeById(userId);
	}
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return empService.addEmployee(emp);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
	}
	@PutMapping("/{update}")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		return empService.updateEmployee(emp);
	}
	
	@GetMapping("/{maxPage}/{ofset}")
	public List<Employee> getAllEmployeesByPagination(@PathVariable int maxPage,@PathVariable int ofset) {
		return empService.getAllEmployeesByPagination(maxPage, ofset);
		
	}
	
	@GetMapping("/name/{Count}")
	public int getEmployeeCount()
	{
		return empService.getEmployeeCount();
	}
	

}

