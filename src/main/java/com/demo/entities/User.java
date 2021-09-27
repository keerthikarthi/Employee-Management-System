package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import java.util.HashSet;
import java.util.Set;

//import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="useremp")
public class User  {
	//private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="userId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String password;
	private String role;
	private int result;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private Employee employee;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
	

}