package com.hbm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee10")
public class Employee {
	
	@Id
	@Column(name="Id")
	private int empId;
	@Column(name="Name")
	private String empName;
	@Column(name="Address")
	private String address;
	@Column(name="Salary")
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String address, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ "]";
	}

}
