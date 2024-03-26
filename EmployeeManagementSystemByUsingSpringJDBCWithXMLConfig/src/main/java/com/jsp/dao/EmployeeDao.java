package com.jsp.dao;

import java.util.List;

import com.jsp.model.Employee;

public interface EmployeeDao {
	
	int employeeRegistration(Employee employee);
	
	int updateSalary(int deptno);
	
	int deleteEmployeeDetails(int id);
	
	Employee getEmployeeById(int id);
	
	void getAllEmployees();
	
	List<Employee> getEmployeeByDeptNo(int deptno);
	
}
