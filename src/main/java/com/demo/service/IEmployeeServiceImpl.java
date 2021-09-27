package com.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.demo.entities.Employee;
import com.demo.repository.IEmployeeRepository;


@Service
public class IEmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repository.findById(id).orElseThrow(
				()-> new EntityNotFoundException("no employee found for the given id"));
		repository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee employee = repository.findById(emp.getUserId()).orElseThrow(
				() -> new EntityNotFoundException("no employee found"));
		employee.setFirstName(emp.getFirstName());
		//employee.setLastName(emp.getLastName());
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>)repository.findAll();
	
	}

	@Override
	public Employee getEmployeeById(int userId) {
		// TODO Auto-generated method stub
		return repository.findById(userId).get();
	}

	@Override
	public List<Employee> getAllEmployeesByPagination(int maxPage, int ofset) {
		// TODO Auto-generated method stub
		Pageable paging = PageRequest.of(maxPage, ofset);
		Page<Employee> pageResult = repository.findAll(paging);
		return pageResult.toList();
		
	} 

	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		return (int) repository.count();
	}

	


}

