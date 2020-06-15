package com.collabera.jdbcdemo.app;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;


import com.collabera.jdbcdemo.dao.CityDao;
import com.collabera.jdbcdemo.dao.CountryDao;
import com.collabera.jdbcdemo.model.City;





/**
 * Hello world!
 *
 */
public class App 
{
	//static Logger log = Logger.getLogger(App.class.getName());
	public static void main(String[] args) throws IOException {
//		Log.debug("Hello World!");
//		Log.info("JDBC test app started..");
//
//		//get properties
		Properties props = new Properties();
		props.load (new FileInputStream ("jdbc.properties"));


		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");

		//connect to database
		Connection conn = null;
		try {
			//log.debug("getting my sql connection .. ");
			conn = (Connection) DriverManager.getConnection(dburl, user , password);
			if(conn!= null) {
				System.out.println("password");

			}
			 String sql  = " select * from city ";
        	 PreparedStatement stmt = conn.prepareStatement(sql);
        	 ResultSet rs = stmt.executeQuery();
        	 while(rs.next()) {
        		 System.out.println(rs.getInt(1)+ " " + rs.getString(2 ) + " " + rs.getString(3) + " " + rs.getString(4));
        	 }
        	 rs.close();
        	 conn.close();
		} catch (Exception ex) {
		//	Log.error(ex.getMessage());

		}


		//test CityDao 
		//Log.info("Testing CityDao...");

		CityDao cityDao = new CityDao();
		try {
			List<City> cities = cityDao.findName("Miami");
			if(cities.size() > 0) {
				//Log.info(cities.get(0));
			}
		} catch ( Exception e) {
			//Log.error(e.getMessage());

		}
	
		System.out.println("Testing CountryDao..");

		CountryDao countryDao = new CountryDao();
		try {
			List<CountryDao> countries = countryDao.findByName("Congo");
			if(countries.size() > 0) {
				System.out.print(countries.get(0));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			String code = "XYZ";
			System.out.println("Success: Delete country: "+ code);
		} catch (Exception x) {
			
		}
	}
}



