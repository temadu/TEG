package ui;

import java.util.LinkedList;
/**
 * UI counterpart the the Console class in the backend.
 * Created and Edited by the ConsoleHandler observer.
 * Access for reading to the frontend (Swing).
 */
public class ConsoleUI {
	private LinkedList<String> console;
	
	public ConsoleUI() {
		console = new LinkedList<String>();
	}

	public LinkedList<String> getConsole() {
		return console;
	}

	public void setConsole(LinkedList<String> console) {
		this.console = console;
	}
}
