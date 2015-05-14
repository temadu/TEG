package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Board {
	
	private HashMap<Continent, HashSet<Country>> continents;
	
	private List<Country> countries;
	private Nexus[][] adjacentMatrix;
	
	public Board() {
		continents = new HashMap<Continent, HashSet<Country>>();
		countries = new ArrayList<Country>();
		//adjacentMatrix
	}
	
	public HashSet<Country> getContinent(Continent continent){
		return continents.get(continent);
	}

}
