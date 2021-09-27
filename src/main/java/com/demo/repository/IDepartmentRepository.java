package com.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.demo.entities.Department;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {

	
	 
}
	


