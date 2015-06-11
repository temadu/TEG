package assets;

import handlers.Observable;
import handlers.Observer;
import handlers.PlayerHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import objectives.Objective;
import objectives.SchatariaObjective;
import situationStrategies.AttackStrategy;
import situationStrategies.TakeCardStrategy;
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
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0 && informationCountry != null){
			informationCountry.incrementSoldiers();
			troopsToAdd--;
		}
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
		if(!attackStrategy.AttackCheck()){
			System.out.println("Cannot attack because of the situation in place.");
			return;
		}
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd == 0)
			subturn = SubTurn.ATTACK;
		attacker.attack(defender);
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
		if(subturn != SubTurn.MOVETROOPS)
			subturn = SubTurn.MOVETROOPS;
		attacker.moveSoldiers(defender);
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
		turn++;
		subturn = SubTurn.ADDTROOPS;
		if(gameStatus != InitialGameStatus.NORMAL_GAME){
			changeInitializingTurn();
			return;
		}
		troopsToAdd = getTurnPlayer().getLeftOverSoldiers();
		countryConquered = false;
		if(turn == players.size()){
			turn = 0;
			changeSituation();
		}
		if(getTurnPlayer().hasLost())
			changeTurn();
	}
	
	private void changeInitializingTurn(){
		if(turn == players.size()){
			turn = 0;
			
			if(gameStatus == InitialGameStatus.FIRST_TURN)
				gameStatus = InitialGameStatus.SECOND_TURN;
			
			if(gameStatus == InitialGameStatus.SECOND_TURN)
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

	public TakeCardStrategy getCardStrategy() {
		return cardStrategy;
	}

	public void setCardStrategy(TakeCardStrategy cardStrategy) {
		this.cardStrategy = cardStrategy;
	}

	public void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
	}
	
}
