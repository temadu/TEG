package objectives;

public class SchatariaObjective extends ConquerorObjective {
	
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
