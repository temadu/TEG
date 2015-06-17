package ui;

import java.util.LinkedList;

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
