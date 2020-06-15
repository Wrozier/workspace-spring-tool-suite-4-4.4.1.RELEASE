package com.collabera.jdbcdemo.dao;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

import com.collabera.jdbcdemo.utils.JdbcUtils;
import com.collabera.jdbctest.model.Department;
import com.collabera.jdbctest.model.Employee;

public class EmployeeDao {


	public List<Employee> getAllEmployees() throws Exception {
		//get db properties
		Properties props = new Properties();
		props.load (new FileInputStream ("jdbc.properties"));


		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");

		List<Employee> list = new ArrayList<Employee>();

		PreparedStatement pstmt =  DriverManager.getConnection(dburl,user, password)
				.prepareStatement("SELECT * FROM employees ");
		
		try {
			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() ) {

				int empid = rs.getInt("employee_id");
				String lastname = rs.getString("Last_name");
				String firstname = rs.getString("First_name");
				int department_id = rs.getInt("Department_Id");
			
				Employee emp = new Employee(department_id, lastname, firstname, null);
				
				emp.setId(empid);
				emp.setLastName(lastname);
				emp.setFirstName(firstname);
				emp.setDepartment(Department.values()[department_id-1]);
				list.add( emp );
			}
		} catch ( SQLException sqle) {
			System.out.println("Error executing:" + sqle);
		}
		return list;
}

	public boolean insert(Employee emp) throws SQLException{
		if( emp == null) return false;
		PreparedStatement statement = JdbcUtils.getConnection()
				.prepareStatement("Insert Into employees (Employee_Id, First_name, Last_name, Department_ID) VALUEs(?,?,?,?)");
		
		statement.setInt(1, emp.getId());
		statement.setString(2, emp.getFirstName());
		statement.setString(3, emp.getLastName());
		statement.setInt(4, emp.getDepartment().ordinal() +1);
		int count = 0;
		try {
			count = statement.executeUpdate();
		} catch ( SQLException sqle) {
			System.out.print("error executing insert for country: " + emp);
			
		} finally {
			statement.close();
		}
		return count > 0 ;

	}
	public boolean delete(int id ) throws SQLException {
		
		PreparedStatement statement = JdbcUtils.getConnection()
				.prepareStatement("DELETE FROM employees WHERE employee_id = ? ");

		statement.setInt(1,  id);
		int count = 0;
		
		try {
			count = statement.executeUpdate();
		}catch(SQLException sqle) {
			System.out.println( "error excecuting delete for employee_id: " + id);

		}finally {
			statement.close();
		}
		return count > 0;
	}
}