package assets;

import java.util.Set;


public class GameManager {

	private static GameManager instance;
	private GameBox gameBox;
	
	private Set<Player> players;
	
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
	}
	
	public GameBox getGameBox() {
		return gameBox;
	}
	
	
	
}
