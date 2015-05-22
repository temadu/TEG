package assets;

import java.util.HashSet;

public class Continent {
	
	private String name;
	private HashSet<Country> countries;
	private int countriesNumber;
	private int soldiersForConqueror;
	
	public Continent(String name, HashSet<Country> countries, int countriesNumber, int soldiersForConqueror) {
		this.name = name;
		this.countries = countries;
		this.countriesNumber = countriesNumber;
		this.soldiersForConqueror = soldiersForConqueror;
	}
	
	public boolean contains(Country country){
		return countries.contains(country);
	}

	public String getName() {
		return name;
	}

	public int getCountriesNumber() {
		return countriesNumber;
	}

	public int getSoldiersForConqueror() {
		return soldiersForConqueror;
	}
	
	
	
	

}
