package objectives;

import assets.GameManager;
/**
 * Objective that gets fulfilled if the next player has lost.
 *
 */
public class DestroyNextPlayerObjective extends Objective{
	
	public DestroyNextPlayerObjective() {
		super.setDescription("Destruir al ejercito del siguiente jugador.");
	}

	@Override
	public boolean checkSpecificObjective() {
		return GameManager.getInstance().getNextPlayer(getOwner()).hasLost();
	}

}
