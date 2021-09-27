package com.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="departId")
	private Department department;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	
	/*public Employee(int userId, String firstName, String lastName, LocalDate dob, String email, Department department) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.email=email;
		this.department=department;
	}
	public Employee(int userId, String firstName, String lastName, String string, String email, String string1) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.email=email;
		this.department=department;
	}*/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}