package handlers;

public interface Observer<T extends Observable> {
	
	public void handleUpdate(T data);
}
