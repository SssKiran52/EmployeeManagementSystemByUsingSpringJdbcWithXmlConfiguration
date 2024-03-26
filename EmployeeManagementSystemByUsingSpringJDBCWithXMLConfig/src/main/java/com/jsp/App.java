package com.jsp;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.dao.EmployeeDao;
import com.jsp.model.Employee;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("sample.xml");
        
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        /*
         * If it is Hard Coded Query we are going to use single argument update method
         */
//        int result = jdbcTemplate.update("insert into employee values(1,'Kiran',50000,10)");
//        
//        if (result!=0) {
//			
//        	System.out.println("Data Inserted...");
//        	
//		} else {
//			
//			System.out.println("Invalid Details..!");
//			
//		}
        
//        int result = jdbcTemplate.update("delete from employee where id=101");
//        
//        if (result!=0) {
//			
//        	System.out.println("Successfully Deleted...");
//        	
//		} else {
//			
//			System.out.println("Invalid Details..!");
//			
//		}
        
//        int result = jdbcTemplate.update("update employee set id=2 where name='Dinga'");
//        
//        if (result!=0) {
//			
//        	System.out.println("Successfully Updated...");
//        	
//		} else {
//			
//			System.out.println("Invalid Details..!");
//			
//		}
        
        EmployeeDao employeeDao = context.getBean("empDaoImpl",EmployeeDao.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("]===> Employee Management System <===[");
        System.out.println();
        System.out.println("Enter \n 1. For Employee Registration "
			        		   + "\n 2. For Salary Updation "
			        		   + "\n 3. For Delete Employee Details "
			        		   + "\n 4. For Employee Details "
			        		   + "\n 5. For All Employees Details"
			        		   + "\n 6. For Employee Details By DeptNo");
        
        int option = scanner.nextInt();
        
        switch (option) {
		case 1:
			
			System.out.println("Enter Employee Id :");
			int empId = scanner.nextInt();
			System.out.println("Enter Employee Name :");
			String empName = scanner.next();
			System.out.println("Enter Employee Salary :");
			Double empSalary = scanner.nextDouble();
			System.out.println("Enter Employee DeptNo :");
			int empDeptNo = scanner.nextInt();
			
			Employee employee = new Employee();
			employee.setEmpid(empId);
			employee.setEmpname(empName);
			employee.setEmpsalary(empSalary);
			employee.setEmpdeptno(empDeptNo);
			
			int registration = employeeDao.employeeRegistration(employee);
	        
	        if (registration!=0) {
				System.out.println("Registration Successfull...");
			} else {
				System.out.println("Insert Valid Values..!");
			}
			
			break;
			
		case 2:
			
			System.out.println("Enter Employee DeptNo :");
			int deptNo = scanner.nextInt();
			
			Employee employee1 = new Employee();
			
			employee1.setEmpdeptno(deptNo);
			
			int update = employeeDao.updateSalary(deptNo);
			
			if (update!=0) {
				System.out.println("Successfully Updated...");
			} else {
				System.out.println("Insert Valid Values..!");
			}
			
			break;
			
		case 3:
			
			System.out.println("Enter Employee Id :");
			int id = scanner.nextInt();
			
			Employee employee2 = new Employee();
			
			employee2.setEmpid(id);
			
			int delete = employeeDao.deleteEmployeeDetails(id);
			
			if (delete!=0) {
				System.out.println("Successfully Deleted...");
			} else {
				System.out.println("Insert Valid Values..!");
			}
			
			break;
		
		case 4:
			
			System.out.println("Enter Employee Id :");
			int empid = scanner.nextInt();
			
			Employee empById = employeeDao.getEmployeeById(empid);
			
			if (empById!=null) {
				
				System.out.println("Employee Id      : "+empById.getEmpid());
				System.out.println("Employee Name    : "+empById.getEmpname());
				System.out.println("Employee Salary  : "+empById.getEmpsalary());
				System.out.println("Employee Dept No : "+empById.getEmpdeptno());
				System.out.println();
				
			} else {
				System.out.println("No Employee Id Found..!");
			}
			
			break;
			
			
		case 5:
			
			  employeeDao.getAllEmployees();
			
			break;
			
		case 6:
			
			 System.out.println("Enter Employee DeptNo :");
			 int dept = scanner.nextInt(); 
			 
			 List<Employee> list = employeeDao.getEmployeeByDeptNo(dept);
			 
			 if (list.isEmpty()) {
				
				 System.out.println("No DeptNo Found..!");
				 
			} else {
				
//				System.out.println(list);
				for (Employee employee3 : list) {
					
					System.out.println("Employee Id      : "+employee3.getEmpid());
					System.out.println("Employee Name    : "+employee3.getEmpname());
					System.out.println("Employee Salary  : "+employee3.getEmpsalary());
					System.out.println("Employee Dept No : "+employee3.getEmpdeptno());
					System.out.println("-------------------------------------");
					
				}
				
			}
			 
			break;	
			
		default:
			
			System.out.println("Enter a Valid Number..!");
			
			break;
		}
         
    }
}
