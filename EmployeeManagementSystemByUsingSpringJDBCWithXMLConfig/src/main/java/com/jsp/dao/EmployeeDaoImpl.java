package com.jsp.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.model.Employee;
import com.jsp.rowmapper.EmployeeRowMapperImpl;
@Component("empDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	Scanner scanner = new Scanner(System.in);
	
	public int employeeRegistration(Employee employee) {
		
		String insert = "insert into employee values(?,?,?,?)";
		
		int result = jdbcTemplate.update(insert, employee.getEmpid(),employee.getEmpname(),employee.getEmpsalary(),employee.getEmpdeptno());
		
		return result;
	}

	public int updateSalary(int deptno) {
		
		System.out.println("Enter Employee Salary :");
		Double sal = scanner.nextDouble();
		
		String update = "update employee set salary=? where deptno=?";
		
		int result = jdbcTemplate.update(update, sal,deptno);
		
		return result;
		
	}

	public int deleteEmployeeDetails(int id) {
		
		String delete = "delete from employee where id=?";
		
		int result = jdbcTemplate.update(delete, id);
		
		return result;
	}

	public Employee getEmployeeById(int id) {
		
		String selectById = "select * from employee where id=?";
		
		RowMapper<Employee> emp = new EmployeeRowMapperImpl();
		
		try {
			
			Employee queryForObject = jdbcTemplate.queryForObject(selectById, emp, id);
			return queryForObject;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public void getAllEmployees() {
		
		String selectAllEmployees = "select * from employee";
		
		RowMapper<Employee> emp = new EmployeeRowMapperImpl();
		
		List<Employee> list = jdbcTemplate.query(selectAllEmployees, emp);
		
//		System.out.println(list);
		for (Employee employee : list) {
		
			System.out.println("Employee Id      : "+employee.getEmpid());
			System.out.println("Employee Name    : "+employee.getEmpname());
			System.out.println("Employee Salary  : "+employee.getEmpsalary());
			System.out.println("Employee Dept No : "+employee.getEmpdeptno());
			System.out.println("-------------------------------------");
			
		}
		
	}

	public List<Employee> getEmployeeByDeptNo(int deptno) {
		
		String selectByDeptNo = "select * from employee where deptno=?";
		
		List<Employee> list = jdbcTemplate.query(selectByDeptNo, new EmployeeRowMapperImpl(),deptno);
		
//		System.out.println(list);
		return list;
		
		
		
	}

}
