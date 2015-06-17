package handlers;

import assets.Console;
import ui.ConsoleUI;
import ui.GameUI;

public class ConsoleHandler implements Observer<Console> {

	private ConsoleUI ui;
	
	public ConsoleHandler() {
		ui = new ConsoleUI();
		GameUI.getInstance().setConsole(ui);
	}
	
	@Override
	public void handleUpdate(Console data) {
		ui.setConsole(data.getConsole());
	}


}
