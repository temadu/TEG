package handlers;

public interface Observable {
	
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}

