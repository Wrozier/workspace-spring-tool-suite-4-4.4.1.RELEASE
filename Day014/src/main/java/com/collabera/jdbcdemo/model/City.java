package com.collabera.jdbcdemo.model;

public class City {
	private int id;
	private String name;
	private int population;
	private String countryCode;
	
	
	public City(){
		super();
	}

	public City(int id, String name, String district, int population, String countryCode) {
		super();
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setDistrict(String string) {
		// TODO Auto-generated method stub
		
	}

}
