package handlers;

import java.util.LinkedList;
import ui.ConsoleUI;
import ui.GameUI;

// Observer of the Console class that changes the ConsoleUI accordingly.
public class ConsoleHandler {

	private ConsoleUI ui;
	
	public ConsoleHandler() {
		ui = new ConsoleUI();
		GameUI.getInstance().setConsole(ui);
	}
	
	public void handleUpdate(LinkedList<String> console) {
		ui.setConsole(console);
	}

}
