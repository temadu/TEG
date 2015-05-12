package backend;

import java.io.Serializable;
import java.util.*;

public class GameBox implements Serializable {

	// Serializable
	private static final long serialVersionUID = 1L;
	
	// Singleton
	private static GameBox game;

	// private Board board;
	private List<Player> players;
	
	private GameBox() {
		
		// board = new Board();
		// players = new ArrayList<Player>();
		
	}
	
	public static GameBox getInstance() {
		if(game == null) {
			game = new GameBox();
		}
		return game;
	}
	
	/* public addPlayer(Player p) {
		
		players.add(p);
		
	} */
	
}
