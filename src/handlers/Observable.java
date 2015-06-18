package handlers;
/**
 * Interface that implements the Observer/Observable Pattern.
 * It will be used to connect the backend classes and their UI counterparts.
 */
public interface Observable {
	
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}

