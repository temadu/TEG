package situations;
/**
 * Interface to be used by the situations. It has a method to start the situation and another to end it.
 * All situations use the Strategy Pattern for changing checks in the code.
 *
 */
public interface Situation {
	
	public void situationStart();
	
	public void situationEnd();
	
	public String getDescription();
	
}
