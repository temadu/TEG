package assets;

import handlers.GameHandler;
import handlers.Observable;
import handlers.Observer;
import handlers.PlayerHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.NEW;

import objectives.Objective;
import objectives.SchatariaObjective;
import situationStrategies.AttackStrategy;
import situationStrategies.NormalAttackStrategy;
import situationStrategies.NormalTakeCardStrategy;
import situationStrategies.TakeCardStrategy;
import situations.NormalSituation;
import situations.Situation;


public class GameManager implements Observable {
	
	public static final int MAX_NUM_PLAYERS = 6;

	private static GameManager instance;
	private GameBox gameBox;
	private InitialGameStatus gameStatus;
	private Situation turnSituation;
	private TakeCardStrategy cardStrategy;
	private AttackStrategy attackStrategy;
	
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
		gameStatus = InitialGameStatus.BEFORE_GAME;
		observers = new HashSet<Observer>();
	}
	
	public static GameManager getInstance() {
		
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
		
	}
	
	public void newGame() {
		players = new ArrayList<Player>();
	}
	
	public void startGame(){
		gameBox = new GameBox();
		dealCountries();
		gameBox.initializeObjectives();
		dealObjectives();
		
		gameStatus = InitialGameStatus.FIRST_TURN;
		troopsToAdd = 8;
		turn = 0;
		subturn = SubTurn.ADDTROOPS;
		countryConquered = false;
		
		turnSituation = new NormalSituation();
		attackStrategy = new NormalAttackStrategy();
		cardStrategy = new NormalTakeCardStrategy();
		
		observers.add(new GameHandler());
		notifyObservers();
		
		System.out.println("troops to add: " + troopsToAdd);
		System.out.println("Terminado START GAME");
	}
	
	public void dealCountries(){
		Player player = players.get(0);
		ArrayList<Country> countries = new ArrayList<>(gameBox.getBoard().getCountries());
		Collections.shuffle(countries);
		for (Country country : countries) {
			country.changeOwner(player);
			System.out.println("Se le asigna el pais " + country.getName() + "al jugador " + player.getName());
			player = getNextPlayer(player);	
		}
	}
	
	public void dealObjectives(){
		for (Player player : players) {
			player.setObjective(gameBox.getRandomObjective());
		}
	}
	
	
	
	public Player getNextPlayer(Player player){
		int playerIndex = players.indexOf(player);
		if(playerIndex == (players.size()-1))
			return players.get(0);
		else
			return players.get(playerIndex+1);
	}
	
	public Player getRandomPlayer(){
		Random r = new Random();
		int randomNumber = r.nextInt(players.size());
		return players.get(randomNumber);
	}
	
	public void addTroop(){
		if(subturn != SubTurn.ADDTROOPS)
			return;
		if(troopsToAdd == 0)
			return;
		if(informationCountry == null)
			return;
		if(!informationCountry.getOwner().equals(getTurnPlayer()))
			return;
		informationCountry.incrementSoldiers();
		troopsToAdd--;
		notifyObservers();
	}
	
	public void attack(){
		if(gameStatus != InitialGameStatus.NORMAL_GAME){
			System.out.println("Cannot attack.");
			return;
		}
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
		if(!attacker.getOwner().equals(getTurnPlayer()))
			return;
		if(attacker.getOwner().equals(defender.getOwner()))
			return;
		if(!attackStrategy.AttackCheck()){
			System.out.println("Cannot attack because of the situation in place.");
			return;
		}
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd == 0)
			subturn = SubTurn.ATTACK;
		attacker.attack(defender);
		notifyObservers();
	}
	
	public void moveSoldiers(){
		if(gameStatus != InitialGameStatus.NORMAL_GAME){
			System.out.println("Cannot move soldiers.");
			return;
		}
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0){
			System.out.println("Cannot move troops. Still got troops to add.");
			return;
		}
		if(attacker == null && defender == null){
			System.out.println("Cannot attack. Need to select a sender and a receiver.");
			return;
		}
		if(!attacker.getOwner().equals(defender.getOwner()))
			return;
		if(!attacker.getOwner().equals(getTurnPlayer()))
			return;
		if(subturn != SubTurn.MOVETROOPS)
			subturn = SubTurn.MOVETROOPS;
		attacker.moveSoldiers(defender);
		notifyObservers();
	}

	public void takeCard(){
		if(countryConquered && cardStrategy.cardTakeCheck()){
			getTurnPlayer().addCountryCard(gameBox.getRandomCard());
			changeTurn();
		}
	}
	
	public void exchangeCards(String cardName1, String cardName2, String cardName3){
		if(subturn != SubTurn.ADDTROOPS)
			return;
		if(getTurnPlayer().returnCountryCards(cardName1, cardName2, cardName3))
			troopsToAdd += (getTurnPlayer().getCardExchangeNumber() * 5);
	}
	
	public void objectivesCheck(){
		for (Player player : players) {
			if(!player.hasLost())
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
		if(troopsToAdd != 0)
			return;
		do{
			turn++;
			subturn = SubTurn.ADDTROOPS;
			
			if(gameStatus != InitialGameStatus.NORMAL_GAME){
				changeInitializingTurn();
				notifyObservers();
				System.out.println(gameStatus);
				System.out.println("Turno de: " + getTurnPlayer().getName());
				return;
			}
			
			if(turn == players.size()){
				turn = 0;
				changeSituation();
				System.out.println(turnSituation.getDescription());
			}
			
			troopsToAdd = getTurnPlayer().getLeftOverSoldiers();
			countryConquered = false;

		}while(getTurnPlayer().hasLost());
		notifyObservers();
		System.out.println("Turno de: " + getTurnPlayer().getName());
	}
	
	private void changeInitializingTurn(){
		if(turn == players.size()){
			turn = 0;
			
			if(gameStatus == InitialGameStatus.FIRST_TURN)
				gameStatus = InitialGameStatus.SECOND_TURN;
			else if(gameStatus == InitialGameStatus.SECOND_TURN)
				gameStatus = InitialGameStatus.NORMAL_GAME;
		}
		if(gameStatus == InitialGameStatus.FIRST_TURN)
			troopsToAdd = 8;
		if(gameStatus == InitialGameStatus.SECOND_TURN)
			troopsToAdd = 4;
		if(gameStatus == InitialGameStatus.NORMAL_GAME)
			troopsToAdd = getTurnPlayer().getLeftOverSoldiers();
	}
	
	private void changeSituation(){
		if(turnSituation != null)
			turnSituation.situationEnd();
		turnSituation = gameBox.getRandomSituation();
		turnSituation.situationStart();
	}
	
	public void addPlayer(String name, String color) {
		Player newplayer = new Player(name, color, new Objective() {
			public boolean checkSpecificObjective() {
				return false;
			}
		});
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
	
	public Player getTurnPlayer(){
		return players.get(turn);
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
		return turnSituation;
	}

	public void setAttacker(String attackerName) {
		this.attacker = gameBox.getBoard().parseStringToCountry(attackerName);
		System.out.println("Se setea en attacker al pais: " + attacker.getName());
		notifyObservers();
	}

	public void setDefender(String defenderName) {
		this.defender = gameBox.getBoard().parseStringToCountry(defenderName);
		System.out.println("Se setea en defener al pais: " + defender.getName());
		notifyObservers();
	}

	public void setInformationCountry(String informationCountryName) {
		this.informationCountry = gameBox.getBoard().parseStringToCountry(informationCountryName);
		System.out.println("Se setea en informationCountry al pais: " + informationCountry.getName());
		notifyObservers();
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

	public TakeCardStrategy getCardStrategy() {
		return cardStrategy;
	}

	public void setCardStrategy(TakeCardStrategy cardStrategy) {
		this.cardStrategy = cardStrategy;
	}

	public void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}

	public InitialGameStatus getGameStatus() {
		return gameStatus;
	}

	public Country getInformationCountry() {
		return informationCountry;
	}

	public Country getAttacker() {
		return attacker;
	}

	public Country getDefender() {
		return defender;
	}
	
}
