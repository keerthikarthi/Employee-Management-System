package com.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Role;
import com.demo.entities.Roles;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(Roles role);
}


