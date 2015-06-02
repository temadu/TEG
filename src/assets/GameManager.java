package assets;

import java.util.ArrayList;


public class GameManager {

	private static GameManager instance;
	private GameBox gameBox;
	
	private ArrayList<Player> players;
	private int turn;
	private SubTurn subturn;
	private int troopsToAdd;
	
	private Country informationCountry;
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
	
	public void addTroop(){
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0 && informationCountry != null){
			informationCountry.incrementSoldiers();
			troopsToAdd--;
		}
	}
	
	public void attack(){
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0){
			System.out.println("Cannot attack. Still got troops to add.");
			return;
		}
		if(subturn == SubTurn.MOVETROOPS){
			System.out.println("Cannot Attack. Already moved troops.");
			return;
		}
		if(attacker == null && defender == null){
			System.out.println("Cannot attack. Need to select an attacker and a defender.");
			return;
		}
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd == 0)
			subturn = SubTurn.ATTACK;
		attacker.attack(defender);
	}
	
	public void moveSoldiers(){
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0){
			System.out.println("Cannot move troops. Still got troops to add.");
			return;
		}
		if(attacker == null && defender == null){
			System.out.println("Cannot attack. Need to select a sender and a receiver.");
			return;
		}
		if(subturn != SubTurn.MOVETROOPS)
			subturn = SubTurn.MOVETROOPS;
		attacker.moveSoldiers(defender);
	}
	
	public void takeCard(){
		
	}
	
	
	public void changeTurn(){
		turn++;
		subturn = SubTurn.ADDTROOPS;
		if(turn == players.size())
			turn = 0;
		if(players.get(turn).hasLost())
			changeTurn();
	}
	
	public void addPlayer(String name, String color) {
		players.add(new Player(name, color));
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

	public void setInformationCountry(Country informationCountry) {
		this.informationCountry = informationCountry;
	}
	
}
