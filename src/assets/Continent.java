package assets;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Represents a continent, which contains countries and the 
 * number of extra troops to give to owner of this continent.
 */

public class Continent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
	
	// Gives the number of troops to give to the owner of the continent.
	public int getSoldiersForConqueror() {
		return soldiersForConqueror;
	}

}
