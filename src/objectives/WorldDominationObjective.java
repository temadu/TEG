package objectives;

public class WorldDominationObjective extends Objective {

	private static final int COUNTRIESNUMBER = 42;
	
	public WorldDominationObjective() {
		super.setDescription("Conquista el mundo!");
	}
	
	@Override
	public boolean checkObjective() {
		return checkSpecificObjective();
	}
	
	@Override
	public boolean checkSpecificObjective() {
		return (super.getOwner().countriesNumber() == COUNTRIESNUMBER);
	}

}
