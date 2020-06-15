package com.collabera.jdbcdemo.dao;

import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.collabera.jdbcdemo.dao.EmployeeDao;
import com.collabera.jdbctest.model.Employee;

public class EmployeeDaoGetAllTest {
@Test
public void testGetAllEmployees() {
	EmployeeDao employeeDao = new EmployeeDao();
	List<Employee> list = new ArrayList <Employee>();
	try {
	 	list = employeeDao.getAllEmployees();
	    } catch (Exception e1) {
	    	e1.printStackTrace();	
		}
	for(Employee e: list)
		System.out.print(e);
		System.out.println("-------------------------");
	assertTrue(list.size() > 0);
	}
	
}

