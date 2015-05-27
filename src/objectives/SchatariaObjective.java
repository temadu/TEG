package objectives;


public class SchatariaObjective extends ConquerorObjective {
	
	private final int ARILIANUM = 3;
	private final int URZANUM = 3;

	public SchatariaObjective() {
		super.setDescription("Conquistar Schataria, 3 paises de Arillia y 3 paises de Urza");
	}
	
	@Override
	public boolean checkSpecificObjective() {
		return ((getOwner().hasContinent(getShataria())) &&
				(getOwner().continentCountries(getArillia()) >= ARILIANUM) &&
				(getOwner().continentCountries(getUrza()) >= URZANUM));
	}

}
