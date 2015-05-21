package backend;


public class GameManager {

	private static GameManager instance;
	private GameBox gameBox;
	
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
