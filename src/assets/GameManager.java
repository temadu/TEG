package assets;

import java.util.ArrayList;

public class GameManager {

	private static GameManager instance;
	private GameBox gameBox;
	
	private ArrayList<Player> players;
	
	// Singleton
	private GameManager() {
		
	}
	
	public static GameManager getInstance() {
		
		if(instance == null) {
			instance = new GameManager();
		}
		return instance;
		
	}
	
	public void newGame() {
		gameBox = new GameBox();
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public boolean isPlayable() {
		return players.size() >= 2;
	}
	
	public GameBox getGameBox() {
		return gameBox;
	}
	
	
	
}
