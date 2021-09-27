package com.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.repository.IEmployeeRepository;
import com.demo.entities.Employee;
import com.demo.service.IEmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class IEmployeeServiceTest {
	@Mock
	private IEmployeeRepository repository;
	@InjectMocks
	private IEmployeeServiceImpl empService;
	
	@Test
	void getAllEmployeesTest() {
		
		List<Employee> list = new ArrayList<Employee>();
		Employee emp1 = new Employee(1,"Rahul","A","2021-08-12","rahul@gmail.com","mech");
	
		list.add(emp1);
		
		
		when(repository.findAll()).thenReturn(list);
		List<Employee> empList = empService.getAllEmployees();
		assertEquals(1,empList.size());
		}

	@Test
	void saveEmployeeTest() {
		Employee emp = new Employee(1,"Rahul","A","2021-08-12","rahul@gmail.com","mech");
		when(repository.save(emp)).thenReturn(emp);
		Employee savedEmp = empService.addEmployee(emp);
		assertThat(savedEmp).isNotNull();
		assertEquals("Rahul", savedEmp.getFirstName());
		assertEquals("A", savedEmp.getLastName());
		
	}
	
}