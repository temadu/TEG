package assets;

import handlers.Observable;
import handlers.Observer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import objectives.Objective;

public class GameBox implements Serializable{

	// Serializable
	private static final long serialVersionUID = 1L;
	
	public static final int MAX_NUM_PLAYERS = 6;
	
	private Board board;
	private HashMap<Objective, Boolean> objectives;
	
	public GameBox() {
		
		//board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		//objectives = ObjectiveFactory.objectiveCreator();
		
	}
	
	

	public Board getBoard() {
		return board;
	}
	
}
