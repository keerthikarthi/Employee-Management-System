package com.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compliance")
public class Compliance implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complianceId")
	private int complianceId;
	private String rlType;
	private String details;
	private LocalDate createDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="departid")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="statusId",nullable = false)
	private StatusReport statusreport;
	
	//@OneToOne(mappedBy="compliance")

	private int empCount;
	private int stsCount;
	private String status;
	
	
	/*public Compliance(int complianceId, String rlType, String details, String string, int empCount, int ststCount, String status) {
		// TODO Auto-generated constructor stub
		this.complianceId=complianceId;
		this.rlType=rlType;
		this.details=details;
		this.createDate=createDate;
		this.empCount=empCount;
		this.stsCount=stsCount;
		this.status=status;	
		
	}*/
	public StatusReport getStatusreport() {
		return statusreport;
	}
	public void setStatusreport(StatusReport statusreport) {
		this.statusreport = statusreport;
	}
	
	public int getComplianceId() {
		return complianceId;
	}
	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}
	public String getRlType() {
		return rlType;
	}
	public void setRlType(String rlType) {
		this.rlType = rlType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	public int getStsCount() {
		return stsCount;
	}
	public void setStsCount(int stsCount) {
		this.stsCount = stsCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}