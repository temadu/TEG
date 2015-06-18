package objectives;
/**
 * Objective to be used in 2-3 player games. Player has to conquer the world.
 */
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
