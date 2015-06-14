package ui;

import java.util.ArrayList;

import assets.SubTurn;

public class GameUI {

	private static GameUI instance;
	
	private String situation;
	
	private ArrayList<PlayerUI> players = new ArrayList<PlayerUI>();
	private int turn;
	private SubTurn subturn;
	private int troopsToAdd;
	
	private ArrayList<CountryUI> countries;
	
	private CountryUI informationCountry;
	private String attacker;
	private String defender;
	
	// Singleton
	private GameUI() {
		turn = 0;
		countries = new ArrayList<CountryUI>();
	}
	
	public static GameUI getInstance() {
		
		if(instance == null) {
			instance = new GameUI();
		}
		return instance;
		
	}

	public void setPlayers(ArrayList<PlayerUI> players) {
		this.players = players;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void setSubturn(SubTurn subturn) {
		this.subturn = subturn;
	}

	public void setTroopsToAdd(int troopsToAdd) {
		this.troopsToAdd = troopsToAdd;
	}

	public ArrayList<PlayerUI> getPlayers() {
		return players;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getAttacker() {
		return attacker;
	}

	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}

	public String getDefender() {
		return defender;
	}

	public void setDefender(String defender) {
		this.defender = defender;
	}

	public int getTurn() {
		return turn;
	}

	public SubTurn getSubturn() {
		return subturn;
	}

	public int getTroopsToAdd() {
		return troopsToAdd;
	}

	public CountryUI getInformationCountry() {
		return informationCountry;
	}

	public void setInformationCountry(CountryUI informationCountry) {
		this.informationCountry = informationCountry;
	}
	
	public void addCountry(CountryUI country){
		countries.add(country);
	}

	public ArrayList<CountryUI> getCountries() {
		return countries;
	}
	
	public CountryUI getCountryUI(String countryName) {
		
		for(int i = 0; i < countries.size() ;i++) {
			if(countries.get(i).getName().equals(countryName))
				return countries.get(i);
		}
		return null;
		
	}
	
}

//
//turno
