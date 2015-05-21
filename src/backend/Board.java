package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Board {
	
	private HashMap<String, Continent> continents;
	
	private List<Country> countries;
	private boolean[][] adjacentMatrix;
	
	public Board() {
		continents = new HashMap<String, Continent>();
		countries = new ArrayList<Country>();
		//adjacentMatrix
	}
	
	public Continent getContinent(String continent){
		return continents.get(continent);
	}
	
	public boolean adjacentCountries(Country attacker, Country defender){
		return adjacentMatrix[countries.indexOf(attacker)][countries.indexOf(defender)];
	}
	
	public Continent continentContainer(Country country){
		Continent container = null;
		for (String continentName : continents.keySet()) {
			if (continents.get(continentName).contains(country)){
				container = continents.get(continentName);
				break;
			}
		}
		return container;
	}

}
