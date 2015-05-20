package objectives;


public class TripleContinentObjective extends ConquerorObjective {

	public TripleContinentObjective() {
		super.setDescription("Conquistar Gilacia, Arlas y Algos");
	}
	
	@Override
	public boolean checkObjective() {
		return ((getOwner().hasContinent(getGilacia())) &&
				(getOwner().hasContinent(getArlas())) &&
				(getOwner().hasContinent(getAlgos())));
	}

}
