package backend;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import objectives.Objective;

public class Player {
	
	private String name;
	private Color color;
	
	private Objective objective;
	private Set<CountryCard> cards;
	
	private int totalSoldiers;
	private int leftOverSoldiers;
	
	private Set<Country> countries;
	
	public Player(String name, Color color, Objective objective) {
		this.name = name;
		this.color = color;
		this.objective = objective;
		this.cards = new HashSet<CountryCard>();
		this.totalSoldiers = 0;
		this.leftOverSoldiers = 0;
		this.countries = new HashSet<Country>();
	}

	public boolean hasLost(){
		return ((totalSoldiers == 0) ? true : false);
	}
	
	public int countriesNumber(){
		return countries.size();
	}

}
