package ui;

import java.util.ArrayList;
import java.util.Iterator;

import assets.SubTurn;

public class GameUI {

	private static GameUI instance;
	
	private String situation;
	
	private ArrayList<PlayerUI> players;
	private PlayerUI winner;
	private int turn;
	private SubTurn subturn;
	private int troopsToAdd;
	
	private ArrayList<CountryUI> countries;
	
	private CountryUI informationCountry;
	
	private String attacker;	// Name of the country that is attacking
	private String defender;	// Name of the country that is defending
	private String attackerOwner;
	private String defenderOwner;
	
    private DiceUI dice;
    
    private ConsoleUI console;
    
	// Singleton
	private GameUI() {
		turn = 0;
		countries = new ArrayList<CountryUI>();
		players = new ArrayList<PlayerUI>();
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
		if(attacker != null) {
			attackerOwner = getOwnerUI(attacker).getName();
		}
	}

	public String getDefender() {
		return defender;
	}

	public void setDefender(String defender) {
		this.defender = defender;
		if(defender != null) {
			defenderOwner = getOwnerUI(defender).getName();
		}
	}
    
    public void setDice(DiceUI dice){
        this.dice = dice;
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
	
	public PlayerUI getOwnerUI(String countryName) {
		
		for(int i = 0; i < players.size(); i++) {
			for(Iterator<CountryUI> itr = players.get(i).getCountries().iterator(); itr.hasNext();) {
				String playerCountryName = itr.next().getName();
				if(playerCountryName.equals(countryName))
					return players.get(i);
			}
		}
		return null;
		
	}

	public DiceUI getDice() {
		return dice;
	}

	public String getAttackerOwner() {
		return attackerOwner;
	}

	public String getDefenderOwner() {
		return defenderOwner;
	}
	
	public void clean() {
		instance = null;
	}

	public PlayerUI getWinner() {
		return winner;
	}

	public void setWinner(PlayerUI winner) {
		this.winner = winner;
	}

	public void setConsole(ConsoleUI console) {
		this.console = console;
	}

	public ConsoleUI getConsole() {
		return console;
	}

}
