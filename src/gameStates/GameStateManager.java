package gameStates;

import java.awt.Graphics2D;

public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;
	
	// Game States
	public static final int NUM_GAME_STATES = 2;
	public final static int MENU_STATE = 0;
	public final static int GET_WHOS_FIRST_STATE = 1;
	
	
	public GameStateManager() {
		
		init();
		
	}
	
	public void init() {
	
		gameStates = new GameState[NUM_GAME_STATES];
		
		// Menu State is the first GameState
		currentState = GET_WHOS_FIRST_STATE;
		loadState(currentState);
		
	}
	
	public void update() {

		if(gameStates[currentState] != null)
			gameStates[currentState].update();
		
	}
	
	private void loadState(int state) {
		
		if(state == MENU_STATE) {
			gameStates[state] = new MenuState();
		}
		if(state == GET_WHOS_FIRST_STATE) {
			gameStates[state] = new GetWhosFirstState();
		}
		
	}
	
	private void unloadState(int state) {
		
		gameStates[state] = null;
		
	}

	public void setState(int state) {
		
		unloadState(currentState);
		currentState = state;	
		loadState(currentState);
		
	}
	
}
