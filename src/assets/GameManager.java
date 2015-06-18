package assets;

import handlers.CountryHandler;
import handlers.GameHandler;
import handlers.Observable;
import handlers.Observer;
import handlers.PlayerHandler;
import io.GameIO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import jdk.nashorn.internal.runtime.regexp.joni.ast.AnyCharNode;
import objectives.Objective;
import situationStrategies.AnyFrontierStrategy;
import situationStrategies.AttackStrategy;
import situationStrategies.NormalAttackStrategy;
import situationStrategies.NormalTakeCardStrategy;
import situationStrategies.TakeCardStrategy;
import situations.NormalSituation;
import situations.Situation;
/**
 * Singleton Class
 * Main class that controls the game. Contains the gamebox and the players.
 * Also receives the commands from the user. 
 */
public class GameManager implements Observable, Serializable {
	

	private static final long serialVersionUID = 1L;

	public static final int MAX_NUM_PLAYERS = 6;

	private static GameManager instance;
	private GameBox gameBox;
	private GameStatus gameStatus;
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
	
	private transient HashSet<Observer> observers;
	
	// Singleton
	private GameManager() {
		gameStatus = GameStatus.BEFORE_GAME;
		observers = new HashSet<Observer>();
	}
	
	public static GameManager getInstance() {
		
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
		
	}
	/**
	 * Creates a new game.
	 */
	public void newGame() {
		players = new ArrayList<Player>();
	}
	
	/**
	 * Initializes the game.
	 */
	public void startGame(){
		gameBox = new GameBox();
		
		new Console();
		
		dealCountries();
		
		if(players.size() > 3)
			gameBox.initializeObjectives();
		dealObjectives();
		
		gameStatus = GameStatus.FIRST_TURN;
		troopsToAdd = 8;
		turn = 0;
		subturn = SubTurn.ADDTROOPS;
		countryConquered = false;
		
		turnSituation = new NormalSituation();
		attackStrategy = new NormalAttackStrategy();
		cardStrategy = new NormalTakeCardStrategy();
		
		observers.add(new GameHandler());
		
		notifyObservers();
		
		Console.add("Iniciando Juego.");

	}
	
	public void loadGame(GameManager game) {
		
		gameBox = game.getGameBox();
		gameStatus = game.getGameStatus();
		turnSituation = game.getSituation();
		cardStrategy = new NormalTakeCardStrategy();
		attackStrategy = new NormalAttackStrategy();
		players = game.getPlayers();
		turn = game.getTurn();
		subturn = game.getSubturn();
		troopsToAdd = game.getTroopsToAdd();
		countryConquered = game.countryConquered;
		informationCountry = game.getInformationCountry();
		attacker = game.getAttacker();
		defender = game.getDefender();
		Country.setFrontierStrategy(new AnyFrontierStrategy());
		turnSituation.situationStart();
		System.out.println(players.get(0).getName());
		notifyObservers();
		initializeAllObservers();
	}
	
	private void initializeAllObservers(){
		for (Player player : players) {
			player.initializeObserver();
		}
		
		for (Country country : gameBox.getBoard().getCountries()) {
			country.initializeObserver();
		}
		
	}
	
	/**
	 * Deals the countries to the players.
	 */
	public void dealCountries(){
		Player player = players.get(0);
		
		ArrayList<Country> countries = new ArrayList<>(gameBox.getBoard().getCountries());
		Collections.shuffle(countries);
		
		for (Country country : countries) {
			country.changeOwner(player);
			player = getNextPlayer(player);	
		}
		
	}
	/**
	 * Deals the objectives to the players.
	 */
	public void dealObjectives(){
		for (Player player : players) {
			player.setObjective(gameBox.getRandomObjective());
		}
	}
	
	public Player getNextPlayer(Player player) {
		
		int playerIndex = players.indexOf(player);
		
		if(playerIndex == (players.size()-1))
			return players.get(0);
		else
			return players.get(playerIndex+1);
		
	}
	
	public Player getRandomPlayer() {
		
		Random r = new Random();
		int randomNumber = r.nextInt(players.size());
		
		return players.get(randomNumber);
		
	}
	
	/**
	 * Adds a troop to the informationCountry selected.
	 * @throws TEGException
	 */
	public void addTroop() throws TEGException {
		
		if(subturn != SubTurn.ADDTROOPS)
			throw new TEGException("");
		
		if(troopsToAdd == 0)
			throw new TEGException("");
		
		if(informationCountry == null)
			throw new TEGException("");
		
		if(!informationCountry.getOwner().equals(getTurnPlayer()))
			throw new TEGException("");
		
		informationCountry.incrementSoldiers();
		troopsToAdd--;
		
		notifyObservers();
		
	}
	
	/**
	 * Performs an attack between the countries selected as attacker and defender if possible.
	 * @throws TEGException
	 */
	public void attack() throws TEGException {
		
		if(gameStatus != GameStatus.NORMAL_GAME)
			throw new TEGException("Cannot attack.");
		
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0)
			throw new TEGException("Cannot attack. Still got troops to add.");

		if(subturn == SubTurn.MOVETROOPS)
			throw new TEGException("Cannot Attack. Already moved troops.");
		
		if(attacker == null || defender == null)
			throw new TEGException("Cannot attack. Need to select an attacker and a defender.");
		
		if(!attacker.getOwner().equals(getTurnPlayer()))
			throw new TEGException("");
		
		if(attacker.getOwner().equals(defender.getOwner()))
			throw new TEGException("");
		
		if(!attackStrategy.AttackCheck())
			throw new TEGException("Cannot attack because of the situation in place.");
		
		if(subturn == SubTurn.ADDTROOPS && troopsToAdd == 0)
			subturn = SubTurn.ATTACK;
		
		if(!attacker.attack(defender))
			throw new TEGException("Those countries cannot attack between themselves");
			
		notifyObservers();
	
	}
	
	/**
	 * Performs a movement of soldiers between the countries selected as attacker and defender if possible.
	 * @throws TEGException
	 */
	public void moveSoldiers() throws TEGException {
		
		if(gameStatus != GameStatus.NORMAL_GAME)
			throw new TEGException("Cannot move soldiers.");

		if(subturn == SubTurn.ADDTROOPS && troopsToAdd > 0)
			throw new TEGException("Cannot move troops. Still got troops to add.");

		if(attacker == null && defender == null)
			throw new TEGException("Cannot attack. Need to select a sender and a receiver.");

		if(!attacker.getOwner().equals(defender.getOwner()))
			throw new TEGException("");
		
		if(attacker.equals(defender))
			throw new TEGException("");
		
		if(!attacker.getOwner().equals(getTurnPlayer()))
			throw new TEGException("");
		
		if(subturn != SubTurn.MOVETROOPS)
			subturn = SubTurn.MOVETROOPS;
		
		attacker.moveSoldiers(defender);
		notifyObservers();
	
	}
	
	/**
	 * Gives a country card to the player if he has already conquered a country and the situation
	 * lets him. Also changes the turn if the card was taken.
	 * @throws TEGException
	 */
	public void takeCard() throws TEGException {
		
		if(countryConquered && cardStrategy.cardTakeCheck()) {
			if(getTurnPlayer().addCountryCard()){
				Console.add(getTurnPlayer().getName() + " took a card.");
				changeTurn();
				return;
			}
		}
		
		throw new TEGException("Cannot get countryCard");
		
	}
	
	/**
	 * Performs an exchange of 3 countryCards for troops if possible.
	 * @param cardName1
	 * @param cardName2
	 * @param cardName3
	 */
	public void exchangeCards(List<String> cards) throws TEGException {
		
		if(subturn != SubTurn.ADDTROOPS)
			throw new TEGException("");
		
		if(cards.size() != 3) 
			throw new TEGException("");
		
		if(getTurnPlayer().returnCountryCards(cards.get(0),cards.get(1), cards.get(2))) {
			troopsToAdd += (getTurnPlayer().getCardExchangeNumber() * 5);
			notifyObservers();
		}
		
	}
	
	/**
	 * Checks if one of the players has won. If so, it calls endGame.
	 */
	public void objectivesCheck(){
		
		for (Player player : players) {
			if(!player.hasLost())
				if(player.getObjective().checkObjective())
					endGame(player);
		}
		
	}
	/**
	 * Finishes the game. Called by objectivesCheck if a player has won.
	 * @param player
	 */
	//TODO FINISH THE GAME
	private void endGame(Player player){
		
		gameStatus = GameStatus.END_GAME;
		Console.add(player.getName() + " has won the game! Congratulations!");
		player.setIsWinner(true);
		
	}
	
	/**
	 * Changes the turn if possible.
	 * @throws TEGException
	 */
	public void changeTurn() throws TEGException {
		
		if(troopsToAdd != 0)
			throw new TEGException("Still have troops to add !");
		do{
			turn++;
			subturn = SubTurn.ADDTROOPS;
			
			if(gameStatus != GameStatus.NORMAL_GAME){
				changeInitializingTurn();
				notifyObservers();
				return;
			}
			
			if(turn == players.size()){
				turn = 0;
				changeSituation();
			}
			
			troopsToAdd = getTurnPlayer().getLeftOverSoldiers();
			countryConquered = false;

		} while(getTurnPlayer().hasLost());
		
		notifyObservers();

	}
	
	/**
	 * Changes the first turns of the game. As they are different from the rest.
	 */
	private void changeInitializingTurn(){
		if(turn == players.size()){
			turn = 0;
			
			if(gameStatus == GameStatus.FIRST_TURN)
				gameStatus = GameStatus.SECOND_TURN;
			else if(gameStatus == GameStatus.SECOND_TURN){
				gameStatus = GameStatus.NORMAL_GAME;
				changeSituation();
				System.out.println(turnSituation.getDescription());
			}
		}
		
		if(gameStatus == GameStatus.FIRST_TURN)
			troopsToAdd = 8;
		
		if(gameStatus == GameStatus.SECOND_TURN)
			troopsToAdd = 4;
		
		if(gameStatus == GameStatus.NORMAL_GAME)
			troopsToAdd = getTurnPlayer().getLeftOverSoldiers();
		
	}
	
	/**
	 * Changes the situation.
	 */
	private void changeSituation(){
		
		if(turnSituation != null)
			turnSituation.situationEnd();
		
		turnSituation = gameBox.getRandomSituation();
		turnSituation.situationStart();
		
	}
	
	/**
	 * Adds a new player to the game. If the color is already used, it overwrites it.
	 * @param name
	 * @param color
	 */
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
	
	public Player getTurnPlayer() {
		return players.get(turn);
	}
	
	public boolean isPlayable() {
		return players.size() >= 2;
	}
	
	public void conqueredACountry() {
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
		notifyObservers();
	
	}

	public void setDefender(String defenderName) {
		
		this.defender = gameBox.getBoard().parseStringToCountry(defenderName);
		notifyObservers();
	
	}

	public void setInformationCountry(String informationCountryName) {
		
		this.informationCountry = gameBox.getBoard().parseStringToCountry(informationCountryName);
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

	public GameStatus getGameStatus() {
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

	public Situation getTurnSituation() {
		return turnSituation;
	}

	public AttackStrategy getAttackStrategy() {
		return attackStrategy;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public boolean isCountryConquered() {
		return countryConquered;
	}

	public HashSet<Observer> getObservers() {
		return observers;
	}
	
}
