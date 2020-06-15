package com.collabera.jdbcdemo.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.collabera.jdbcdemo.model.City;

public class CityDao {

	//private static final Logger logger = Logger.getLogger(CityDao.class.getName()); 
	// private static final CountryDaovcountryDao;
	HashMap<Integer, City> cache = new HashMap<Integer, City>();


	/** retrieve a city by its id 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException */
	public City findById( Integer id ) throws SQLException, FileNotFoundException, IOException {
		if ( cache.containsKey(id) ) return cache.get(id);
		List<City> list = find("WHERE id = " + id);
		return list.get(0);

	}


	/** retrieve a city by name 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException */
	public List<City> findName( String name) throws SQLException, FileNotFoundException, IOException {
		name = sanitize(name);
		List<City> list = find("WHERE name =" + name+ "'");
		return list;
	}
	private String sanitize(String name) {
		return name;
	}


	@SuppressWarnings("finally")
	public List<City> find( String query) throws SQLException, FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load (new FileInputStream ("jdbc.properties"));


		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");

		ArrayList<City> list = new ArrayList<City>();
		Statement stmt = DriverManager
				.getConnection(dburl,user,password).createStatement();

		String sqlquery = "SELECT * FROM city c " + query;

		try {
			//logger.debug("executing query: " + sqlquery );
			System.out.print("");
			ResultSet rs = stmt.executeQuery( sqlquery);
			while (rs.next() ) {
				City c = resultSetToCity( rs ) ;
				list.add(c);
			}
		} catch ( SQLException sqle ) {
			//logger.error("error executing: " + sqlquery, sqle);
			System.out.print("");
		} finally {
			if (stmt!= null) try { stmt.close(); }
			catch(final SQLException e) { /* ignore it */ }
			return list;
		}

	}



	private City resultSetToCity(ResultSet rs) throws SQLException {
		City  city  ;
		
		Integer id = rs.getInt("id");
		//is this city already in cache? if so , use it
		if ( cache.containsKey(id) ) city = cache.get(id);
		else city = new City ();
		
		city.setId(id);
		city.setName( rs.getString("Name"));
		city.setDistrict( rs.getString("District"));
		city.setPopulation( rs.getInt("Population"));
		city.setCountryCode( rs.getString("CountryCode"));
		
		
		
		//add this city to the cache 
		if ( ! cache.containsKey(id) ) cache.put( id, city);
		
		return city;
		//now get reference to the country this city refers
		//System.out.println("get country for city " +countrycode city.getName() );
		
	}
	

}


