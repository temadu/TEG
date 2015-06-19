package objectives;

/**
 * Objective that gets fulfilled if the player conquers Schataria, 3 arillian countries and 3 urzan countries.
 */
public class SchatariaObjective extends ConquerorObjective {
	
	private static final long serialVersionUID = 1L;
	
	private final int ARILIANUM = 3;
	private final int URZANUM = 3;

	public SchatariaObjective() {
		super.setDescription("Conquer Schataria, 3 countries from Arillia and 3 countries from Urza.");
	}
	
	@Override
	public boolean checkSpecificObjective() {
		
		return ((getOwner().hasContinent(getSchataria())) &&
				(getOwner().continentCountries(getArillia()) >= ARILIANUM) &&
				(getOwner().continentCountries(getUrza()) >= URZANUM));
	
	}

}
