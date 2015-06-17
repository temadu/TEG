package handlers;

import java.util.ArrayList;
import java.util.LinkedList;

import assets.Console;
import ui.ConsoleUI;
import ui.GameUI;

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
