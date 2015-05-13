package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
	
	private HashMap<Continent, ArrayList<Country>> continents;
	
	private List<Country> countries;
	private Nexus[][] adjacentMatrix;
	
	public Board() {
		continents = new HashMap<Continent, ArrayList<Country>>();
		countries = new ArrayList<Country>();
		//adjacentMatrix
	}

}
