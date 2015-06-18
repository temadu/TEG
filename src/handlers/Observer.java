package handlers;
/**
 * Interface that implements the Observer/Observable Pattern.
 * It will be used to connect the backend classes and their UI counterparts.
 */
public interface Observer<T extends Observable> {
	
	public void handleUpdate(T data);
}
