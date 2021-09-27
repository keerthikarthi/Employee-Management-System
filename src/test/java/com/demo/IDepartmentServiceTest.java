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

import com.demo.repository.IDepartmentRepository;
import com.demo.entities.Department;
import com.demo.service.IDepartmentServiceImpl;


@ExtendWith(MockitoExtension.class)
class IDepartmentServiceTest {
@Mock
	private IDepartmentRepository repository;
@InjectMocks
	private IDepartmentServiceImpl departService;
		

	@Test
	void getAllDepartmentsTest() {
		
		List<Department> list = new ArrayList<Department>();
		Department dept = new Department(1,"Hr");
	
		list.add(dept);
		
		when(repository.findAll()).thenReturn(list);
		List<Department> deptList = departService.getAllDepartments();
		assertEquals(1,deptList.size());
		}

	@Test
	void saveDepartmentTest() {
		Department dept = new Department(1,"Hr");
		when(repository.save(dept)).thenReturn(dept);
		Department savedDept = departService.addDepartment(dept);
		assertThat(savedDept).isNotNull();
		assertEquals("Hr", savedDept.getDepartName());
	}

}
