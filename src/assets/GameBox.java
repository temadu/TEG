package assets;

import java.io.Serializable;
import java.util.*;

public class GameBox implements Serializable {

	// Serializable
	private static final long serialVersionUID = 1L;
	
	public static final int MAX_NUM_PLAYERS = 6;
	
	private Board board;
	private Set<Player> players;
	
	public GameBox() {
		
		board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		players = new HashSet<Player>();
		
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
