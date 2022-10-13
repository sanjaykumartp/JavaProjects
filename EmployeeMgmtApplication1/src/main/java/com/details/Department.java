package com.details;

import javax.persistence.*;

@Entity

@Table (name = "department")
public class Department {
	@Id @Column(name="deptNo")	private	int deptNo;
	@Column(name="deptName")	private String deptName;
	@Column(name="purpose")		private String purpose;

	public Department(int departNo, String deptName, String purpose) {
		super();
		this.deptNo = departNo;
		this.deptName = deptName;
		this.purpose = purpose;
	}
	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getDepartNo() {
		return deptNo;
	}

	public void setDepartNo(int departNo) {
		this.deptNo = departNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public int hashCode() {
		return deptNo;
	}

	@Override
	public boolean equals(Object obj) {
		Department ref = (Department)obj;
		return this.deptNo==ref.deptNo;
	}
	
	@Override
	public String toString() {
		String result = "Department number = "+deptNo+"\nDepartment name = "+deptName+"\nDepartment purpose = "+purpose;            
		return result;
	}


}