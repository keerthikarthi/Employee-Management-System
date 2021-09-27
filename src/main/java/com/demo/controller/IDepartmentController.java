package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Department;
import com.demo.entities.Employee;
import com.demo.service.IDepartmentService;

@RestController
@RequestMapping("/department")
public class IDepartmentController {
@Autowired
	IDepartmentService departService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addDepartment(@RequestBody Department dname)
	{
		departService.addDepartment(dname);
	}
	
	@GetMapping
	public List<Department> getAllDepartments()
	{
		return departService.getAllDepartments();
	}

	@GetMapping("/{maxPage}/{ofset}")
	public List<Department> getAllDepartByPagination(@PathVariable int maxPage,@PathVariable int ofset) {
		return departService.getAllDepartByPagination(maxPage, ofset);
		
	}
	@GetMapping("/name/{Count}")
	public int getAllDepartCount()
	{
		return departService.getAllDepartCount();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteDepartment(@PathVariable int id) {
		departService.deleteDepartment(id);
	}

}



	