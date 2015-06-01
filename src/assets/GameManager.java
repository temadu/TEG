package assets;

import java.util.ArrayList;


public class GameManager {

	private static GameManager instance;
	private GameBox gameBox;
	
	private ArrayList<Player> players;
	private int turn;
	private SubTurn subturn;
	
	private Country attacker;
	private Country defender;
	
	// Singleton
	private GameManager() {
		turn = 0;
	}
	
	public static GameManager getInstance() {
		
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
		
	}
	
	public void newGame() {
		gameBox = new GameBox();
		players = new ArrayList<Player>();
	}
	
	//Needs SubturnCheck
	public void attack(){
		if(attacker != null && defender != null)
			attacker.attack(defender);
	}
	
	//Needs SubturnCheck
	public void moveSoldiers(){
		if(attacker != null && defender != null)
			attacker.moveSoldiers(defender);
	}
	
	public void changeTurn(){
		turn++;
		subturn = SubTurn.ADDTROOPS;
		if(turn == players.size())
			turn = 0;
		if(players.get(turn).hasLost())
			changeTurn();
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public boolean isPlayable() {
		return players.size() >= 2;
	}
	
	public GameBox getGameBox() {
		return gameBox;
	}

	public void setAttacker(Country attacker) {
		this.attacker = attacker;
	}

	public void setDefender(Country defender) {
		this.defender = defender;
	}
	
}
