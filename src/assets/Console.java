package assets;

import handlers.ConsoleHandler;
import java.util.LinkedList;

// A console to be used to give feedback to the player.
public class Console  {

	private static LinkedList<String> console;
	private static ConsoleHandler observer;

	public final static int LINES = 50;
	
	public Console() {
	
		console = new LinkedList<String>();
		observer = new ConsoleHandler();
	
	}
	
	/**
	 * Adds a message to the console.
	 * @param message
	 */
	public static void add(String message){
		
		if(console.size() < LINES)
			console.addLast(message);
		else{
			console.removeFirst();
			console.addLast(message);	
		}		
		
		observer.handleUpdate(console);
	
	}

	public static LinkedList<String> getConsole() {
		return console;
	}
	
}
