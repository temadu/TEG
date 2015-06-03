package ui;

import java.util.ArrayList;
import assets.SubTurn;

public class GameUI {

	private static GameUI instance;
	
	//private Situation situation;
	
	private ArrayList<PlayerUI> players;
	private int turn;
	private SubTurn subturn;
	private int troopsToAdd;
	
	
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
	
}


//array de jugadores 
//situation
//turno