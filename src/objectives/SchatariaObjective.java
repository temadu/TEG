package objectives;

import backend.Continent;

public class SchatariaObjective extends ConquerorObjective {
	
	private final int ARILIANUM = 3;
	private final int URZANUM = 3;

	public SchatariaObjective() {
		super.setDescription("Conquistar Schataria, 3 paises de Arillia y 3 paises de Urza");
	}
	
	@Override
	public boolean checkObjective() {
		return ((intersectionNumber(Continent.SCHATARIA) == super.SHATARIACOUNTRIESNUM) &&
				(intersectionNumber(Continent.ARILLIA) >= ARILIANUM) &&
				(intersectionNumber(Continent.URZA) >= URZANUM));
	}

}
