package objectives;

public class TripleContinentObjective extends ConquerorObjective {

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
