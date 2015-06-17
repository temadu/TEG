package assets;

import handlers.ConsoleHandler;
import handlers.Observable;
import handlers.Observer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Console implements Observable {

	private static LinkedList<String> console;
	private static int LINES = 6;
	private static ArrayList<Observer> observers;
	
	public Console() {
		console = new LinkedList<String>();
		observers = new ArrayList<Observer>();
		addObserver(new ConsoleHandler());
	}
	
	public static void add(String message){
		if(console.size() < LINES)
			console.addLast(message);
		else{
			console.removeFirst();
			console.addLast(message);	
		}		
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.handleUpdate(this);
		}
	}

	public static LinkedList<String> getConsole() {
		return console;
	}
}
