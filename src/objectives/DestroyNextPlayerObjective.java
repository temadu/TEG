package objectives;

import assets.Player;

public class DestroyNextPlayerObjective extends Objective{
	
	private Player enemy;
	
	public DestroyNextPlayerObjective() {
		//this.enemy = GameManager.getInstance().getNextPlayer();
		super.setDescription("Destruir al ejercito de color " + enemy.getColor().toString());
	}

	@Override
	public boolean checkSpecificObjective() {
		return enemy.hasLost();
	}

}
