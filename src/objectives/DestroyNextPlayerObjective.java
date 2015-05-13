package objectives;

import backend.GameBox;
import backend.Player;

public class DestroyNextPlayerObjective extends Objective{
	
	private String description;
	private Player enemy;
	
	public DestroyNextPlayerObjective() {
		this.description = "Destruir al ejercito del siguiente jugador";
		//this.enemy = GameManager.getInstance().getNextPlayer();
		
	}

	@Override
	public boolean checkObjective() {
		return (generalObjectiveCheck() || enemy.hasLost());
	}

}
