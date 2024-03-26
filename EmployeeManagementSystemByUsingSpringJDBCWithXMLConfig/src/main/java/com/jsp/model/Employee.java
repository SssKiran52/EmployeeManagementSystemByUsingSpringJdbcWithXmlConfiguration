package com.jsp.model;

public class Employee {
	
	private int empid;
	private String empname;
	private double empsalary;
	private int empdeptno;
	
	public Employee() {
//		super();
	}

	public Employee(int empid, String empname, double empsalary, int empdeptno) {
//		super();
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
		this.empdeptno = empdeptno;
	}
	
	

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public int getEmpdeptno() {
		return empdeptno;
	}

	public void setEmpdeptno(int empdeptno) {
		this.empdeptno = empdeptno;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + ", empdeptno="
				+ empdeptno + "]";
	}
		
	
}
