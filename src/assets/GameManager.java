package assets;

import handlers.Observable;
import handlers.Observer;
import handlers.PlayerHandler;
import java.util.ArrayList;
import java.util.HashSet;

import situations.Situation;


public class GameManager implements Observable {
	
	public static final int MAX_NUM_PLAYERS = 6;

	private static GameManager instance;
	private GameBox gameBox;
	private Situation situation;
	
	private ArrayList<Player> players;
	private int turn;
	private SubTurn subturn;
	private int troopsToAdd;
	private boolean countryConquered;
	
	private Country informationCountry;
	private Country attacker;
	private Country defender;
	
	private HashSet<Observer> observers;
	
	// Singleton
	private GameManager() {
		
	}
	
	public static GameManager getInstance() {
		
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
		
	}
	
	public void newGame() {
		gameBox = new GameBox();
		gameBox.initializeObjectives();
		players = new ArrayList<Player>();
		turn = 0;
		subturn = SubTurn.ADDTROOPS;
		countryConquered = false;
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
		if(countryConquered)
			players.get(turn).addCountryCard(gameBox.getRandomCard());
	}
	
	public void objectivesCheck(){
		for (Player player : players) {
			if(player.getObjective().checkObjective())
				endGame(player);
		}
	}
	
	//TODO FINISH THE GAME
	private void endGame(Player player){
		System.out.println("CONGRATULATIONS PLAYER " + player.getName() + ".");
		System.out.println("YOU HAVE WON THIS GAME!!!");
	}
	
	
	public void changeTurn(){
		turn++;
		subturn = SubTurn.ADDTROOPS;
		troopsToAdd = players.get(turn).getLeftOverSoldiers();
		countryConquered = false;
		if(turn == players.size()){
			turn = 0;
			changeSituation();
		}
		if(players.get(turn).hasLost())
			changeTurn();
	}
	
	private void changeSituation(){
		if(situation != null)
			situation.situationEnd();
		situation = gameBox.getRandomSituation();
		situation.situationStart();
	}
	
	public void addPlayer(String name, String color) {
		Player newplayer = new Player(name, color);
		for (Player oldplayer : players) {
			if(oldplayer.equals(newplayer)){
				oldplayer.setName(name);
				return;
			}
		}
		if(players.size() < MAX_NUM_PLAYERS){
			players.add(newplayer);
			newplayer.addObserver(new PlayerHandler(newplayer));
		}
	}
	
	public boolean isPlayable() {
		return players.size() >= 2;
	}
	
	public void conqueredACountry(){
		countryConquered = true;
	}
	
	public GameBox getGameBox() {
		return gameBox;
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

	public Situation getSituation() {
		return situation;
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

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);	
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.handleUpdate(this);
		}	
	}
	
}
