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
	private Set<Player> players;
	private HashMap<Objective, Boolean> objectives;
	
	public GameBox() {
		
		//board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		players = new HashSet<Player>();
		//objectives = ObjectiveFactory.objectiveCreator();
		
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}

	public Board getBoard() {
		return board;
	}

	public Set<Player> getPlayers() {
		return players;
	}
	
	public boolean isPlayable() {
		return players.size() >= 2;
	}

	
	
}
