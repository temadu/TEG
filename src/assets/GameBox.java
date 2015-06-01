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
	
	public static final int MAX_NUM_PLAYERS = 6;
	
	private Board board;
	private ArrayList<Objective> objectives;
	private ArrayList<Situation> situations;
	
	public GameBox() {
		
		//board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		//objectives = ObjectiveFactory.objectiveCreator();
		//situations = SituationFactory.situationCreator();
		
	}
	
	

	public Board getBoard() {
		return board;
	}
	
	public Objective getRandomObjective(){
		Objective objective = objectives.get(0);
		objectives.remove(0);
		objectives.add(objective);
		return objective;
	}
	
	public Situation getRandomSituation(){
		Collections.shuffle(situations);
		return situations.get(0);
	}
	
}
