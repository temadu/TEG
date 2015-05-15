package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Board {
	
	private HashMap<Continent, HashSet<Country>> continents;
	
	private List<Country> countries;
	private boolean[][] adjacentMatrix;
	
	public Board() {
		continents = new HashMap<Continent, HashSet<Country>>();
		countries = new ArrayList<Country>();
		//adjacentMatrix
	}
	
	public HashSet<Country> getContinent(Continent continent){
		return continents.get(continent);
	}
	
	public boolean adjacentCountries(Country attacker, Country defender){
		return adjacentMatrix[countries.indexOf(attacker)][countries.indexOf(defender)];
	}

}
