package ui;

import java.util.ArrayList;

import assets.Country;
import assets.SubTurn;

public class GameUI {

	private static GameUI instance;
	
	private String situation;
	
	private ArrayList<PlayerUI> players;
	private int turn;
	private SubTurn subturn;
	private int troopsToAdd;
	
	private CountryUI informationCountry;
	private String attacker;
	private String defender;
	
	// Singleton
	private GameUI() {
		turn = 0;
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
	
	
}


//array de jugadores 
//situation
//turno