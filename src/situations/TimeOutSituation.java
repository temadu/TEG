package situations;

import situationStrategies.TimeOutAttackStrategy;
import assets.GameManager;
import assets.Player;

/**
 * Situation that prohibits a a random player to attack so they can only add troops and move them.
 * Changes the AttackStrategy in GameManager.
 */
public class TimeOutSituation extends NoAttackSituation {
	
	private static final long serialVersionUID = 1L;
	
	private Player sufferer;
	private String description;

	public TimeOutSituation() {
		sufferer = GameManager.getInstance().getRandomPlayer();
		super.setAttackStrategy(new TimeOutAttackStrategy(sufferer));
		description = "TimeOut "; 
	}

	@Override
	public String getDescription() {
		return description + sufferer.getColor();
	}

}
