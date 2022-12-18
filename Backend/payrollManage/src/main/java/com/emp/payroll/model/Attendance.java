package com.emp.payroll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String Date;
	private String Status;
	
	public Attendance(long empId, String date, String status) {
		super();
		this.empId = empId;
		Date = date;
		Status = status;
	}

	public Attendance() {}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
  
//  public Attendance() {
//	  
//  }
//public Attendance(String Date, String Status, long empId) {
//	super();
//	this.empId = empId;
//	this.Date = Date;
//	this.Status = Status;
//}
//public long getEmpId() {
//	return empId;
//}
//public void setEmpId(long empId) {
//	this.empId = empId;
//}
//public String getDate() {
//	return Date;
//}
//public void setDate(String Date) {
//	this.Date = Date;
//}
//public String getStatus() {
//	return Status;
//}
//public void setStatus(String Status) {
//	this.Status = Status;
//}
//  
//  
//}
}