package com.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department implements Serializable {
	@Id
	@Column(name ="departId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int departId;
	private String departName;
	/*public Department(int departId, String departName) {
		// TODO Auto-generated constructor stub
		this.departId=departId;
		this.departName=departName;
	}*/
	@OneToOne(mappedBy="department")
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	

}
