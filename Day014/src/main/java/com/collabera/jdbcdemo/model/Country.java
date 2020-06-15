package com.collabera.jdbcdemo.model;

public class Country {

		private String code;
		private String name;
		private String continent;
		private String region;
		private int population;
		
		
		
		public Country(){
			super();
		}

		public Country(int id, String name,  int population, String code, String continent, String region) {
			super();
			
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.region = region;
			this.population = population ;


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

		

		public void setDistrict(String string) {
			// TODO Auto-generated method stub
			
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getContinent() {
			return continent;
		}

		public void setContinent(String continent) {
			this.continent = continent;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

	}

