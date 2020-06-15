package com.collabera.jdbcdemo.dao;

import static org.junit.Assert.assertTrue;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.collabera.jdbcdemo.utils.JdbcUtils;
import com.collabera.jdbctest.model.Employee;

public class EmployeeDaoGetInsertTest {
	
	@Test 
	public void InsertTest(boolean instered) {
		EmployeeDao employeeDao  = new EmployeeDao();
		boolean inserted = false;
		try {
			instered = employeeDao.insert(new Employee (0, "Rozier"  , "William", 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(inserted);
	}

}
