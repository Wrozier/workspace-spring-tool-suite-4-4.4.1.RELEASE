package com.collabera.jdbcdemo.dao;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.collabera.jdbcdemo.model.Country;
import com.collabera.jdbcdemo.utils.JdbcUtils;

public class CountryDao {



	public List<CountryDao> findByName( String name) throws Exception {
		//get db properties
		Properties props = new Properties();
		props.load (new FileInputStream ("jdbc.properties"));


		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");

		List<CountryDao> list = new ArrayList<CountryDao>( );

		PreparedStatement pstmt =  DriverManager.getConnection(dburl,user, password)
				.prepareStatement("SELECT * FROM Country where name = ? ");
		pstmt.setString(1,  "Thailand");
		try {
			ResultSet rs = pstmt .executeQuery();
			while ( rs.next() ) {
				CountryDao c = resultSetToCountry( rs );
				list.add( c );
			}
		} catch ( SQLException sqle) {

		}
		return list;
	}
	
	
	public boolean insert ( Country country) throws SQLException {
		if( country == null) return false;
		PreparedStatement statement = JdbcUtils.getConnection()
				.prepareStatement("Insert Into country (code, name, continent, region) VALUEs");
		
		statement.setString(1, country.getCode());
		statement.setString(2, country.getName());
		statement.setString(3, country.getContinent());
		statement.setString(4, country.getRegion());
		int count = 0;
		try {
			count = statement.executeUpdate( );
		} catch ( SQLException sqle) {
			System.out.print("error executing insert for country: " + country);
			
		} finally {
			statement.close();
		}
		return count > 0 ;
		
		}
	
	
	
	public boolean delete( String code) throws SQLException {
		if ( code == null ) return false;
		
		PreparedStatement statement = JdbcUtils.getConnection()
				.prepareStatement("DELETE FROM Country WHERE code = ?");

		statement.setString(1,  code);
		int count = 0;
		
		try {
			count = statement.executeUpdate();
		}catch(SQLException sqle) {
			System.out.println( "error excecuting delete for code: " + code);

		}finally {
			statement.close();
		}
		return count > 0;
	}
	
	
	
	
	
	


	private CountryDao resultSetToCountry(ResultSet rs) {
		return null;
	}
}
	

