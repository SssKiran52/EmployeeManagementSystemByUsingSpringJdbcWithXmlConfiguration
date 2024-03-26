package com.jsp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jsp.model.Employee;

public class EmployeeRowMapperImpl implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setEmpid(rs.getInt(1));
		employee.setEmpname(rs.getString(2));
		employee.setEmpsalary(rs.getDouble(3));
		employee.setEmpdeptno(rs.getInt(4));
		
		return employee;
	}

}
