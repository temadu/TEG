package objectives;

public class TripleContinentObjective extends ConquerorObjective {

	private static final long serialVersionUID = 1L;

	public TripleContinentObjective() {
		super.setDescription("Conquer Gilacia, Arlas and Algos.");
	}
	
	@Override
	public boolean checkSpecificObjective() {
		
		return ((getOwner().hasContinent(getGilacia())) &&
				(getOwner().hasContinent(getArlas())) &&
				(getOwner().hasContinent(getAlgos())));
	
	}

}
