package assets;

import handlers.ConsoleHandler;

import java.util.LinkedList;

public class Console  {

	private static LinkedList<String> console;
	public final static int LINES = 50;
	private static ConsoleHandler observer;
	
	public Console() {
		console = new LinkedList<String>();
		observer = new ConsoleHandler();
	}
	
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
