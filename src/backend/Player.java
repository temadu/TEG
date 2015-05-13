package backend;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import objectives.Objective;

public class Player {
	
	private String name;
	private Color color;
	
	private Objective objective;
	
	private int totalSoldiers;
	private int leftOverSoldiers;
	
	private Set<Country> countries;
	private Set<CountryCard> cards;
	
	public Player(String name, Color color, Objective objective) {
		this.name = name;
		this.color = color;
		this.objective = objective;
		this.objective.setOwner(this);
	
		this.totalSoldiers = 0;
		this.leftOverSoldiers = 0;
		this.countries = new HashSet<Country>();
		this.cards = new HashSet<CountryCard>();
	}
	
	public boolean hasLost(){
		return ((totalSoldiers == 0) ? true : false);
	}
	
	public int countriesNumber(){
		return countries.size();
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public Objective getObjective() {
		return objective;
	}

	public int getTotalSoldiers() {
		return totalSoldiers;
	}

	public int getLeftOverSoldiers() {
		return leftOverSoldiers;
	}

	public Set<Country> getCountries() {
		return countries;
	}

	public Set<CountryCard> getCards() {
		return cards;
	}

}
