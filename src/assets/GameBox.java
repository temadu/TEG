package assets;

import handlers.Observable;
import handlers.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import objectives.Objective;
import situations.Situation;

public class GameBox implements Serializable{

	// Serializable
	private static final long serialVersionUID = 1L;
	
	private Board board;
	private ArrayList<Objective> objectives;
	private ArrayList<Situation> situations;
	private ArrayList<CountryCard> countryCards;
	
	public GameBox() {
		
		board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		//situations = SituationFactory.situationCreator();
		//countryCards = CountryCardFactory.countryCardsCreator(board.getCountries());
	}
	
	public void initializeObjectives(){
		objectives = ObjectiveFactory.objectiveCreator();
	}

	public Board getBoard() {
		return board;
	}
	
	public Objective getRandomObjective(){
		Objective objective = objectives.get(0);
		objectives.remove(0);
		return objective;
	}
	
	public Situation getRandomSituation(){
		Collections.shuffle(situations);
		return situations.get(0);
	}
	
	public CountryCard getRandomCard(){
		CountryCard card = countryCards.get(0);
		countryCards.remove(0);
		return card;
	}
	
	public void returnCountryCards(CountryCard card1, CountryCard card2, CountryCard card3){
		countryCards.add(card1);
		countryCards.add(card2);
		countryCards.add(card3);
	}
	
}
