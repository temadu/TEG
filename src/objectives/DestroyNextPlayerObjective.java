package objectives;

import assets.GameManager;

// Objective that gets fulfilled if the next player has lost.
public class DestroyNextPlayerObjective extends Objective{
	
	private static final long serialVersionUID = 1L;

	public DestroyNextPlayerObjective() {
		super.setDescription("Destroy your following Player.");
	}

	@Override
	public boolean checkSpecificObjective() {
		return GameManager.getInstance().getNextPlayer(getOwner()).hasLost();
	}

}
