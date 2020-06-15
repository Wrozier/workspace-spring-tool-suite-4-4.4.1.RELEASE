package com.collabera.jdbcdemo.app;

import java.sql.*;

public class JdbcTestApp {

	public static void main(String[] args) {
         Connection conn = null;
         try {
        	 conn = (Connection) DriverManager
        			 .getConnection("jdbc:mysql://localhost:3306/employeesdb", "root", "Idkmypw5724");
        	 if(conn!= null) {
        		 System.out.println("mysql connection successfully aquired!");
        	 }
        	 String sql  = " select * from employees ";
        	 PreparedStatement stmt = ((java.sql.Connection) conn).prepareStatement(sql);
        	 ResultSet rs = stmt.executeQuery();
        	 while(rs.next()) {
        		 System.out.println(rs.getInt(1)+ " " + rs.getString(2 ) + " " + rs.getString(3) + " " + rs.getString(4));
        	 }
        	 rs.close();
        	 conn.close();
         } catch (Exception ex) {
        	 System.out.println(ex.getMessage());

         }
	}
}
