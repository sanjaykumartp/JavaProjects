package com.details;

import javax.persistence.*;

@Entity
//Table Name
@Table (name = "employee")
public class Employee {
	//empId, empName, dob, designation, deptNo, salary
	

	//Mapping
	@Id @Column(name="emp_id")		private int empId;
	@Column(name="emp_name")		private String empName;
	@Column(name="dob")			private String dob; 
	@Column(name="designation")	private String designation ;

	@Column(name="dept_no")		    private int deptNo;
	@Column(name="salary")		private double salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empId, String empName, String dob, String designation, int deptNo, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dob = dob;
		this.designation = designation;
		this.deptNo = deptNo;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return empId;
	}
	@Override
	public boolean equals(Object obj) {
		Employee ref = (Employee)obj;
		return this.empId==ref.empId;
	}
	@Override
	public String toString() {
		String details = "Employee id = "+ empId+ "\nEmployee name = "+ empName +"\nEmployee Date of Birth = "+dob+"\nDesignation = "+ designation +"\nSalary = "+salary;
		return details;
	}
	
}
