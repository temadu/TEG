package backend;

import java.io.Serializable;
import java.util.*;

public class GameBox implements Serializable {

	// Serializable
	private static final long serialVersionUID = 1L;
	
	private Board board;
	private List<Player> players;
	
	public GameBox() {
		
		board = new Board();
		players = new ArrayList<Player>();
		
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}

	public Board getBoard() {
		return board;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
}
