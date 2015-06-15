package situations;

import situationStrategies.TimeOutAttackStrategy;
import assets.GameManager;
import assets.Player;

public class TimeOutSituation extends NoAttackSituation {
	
	private Player sufferer;
	private String description;

	public TimeOutSituation() {
		sufferer = GameManager.getInstance().getRandomPlayer();
		super.setAttackStrategy(new TimeOutAttackStrategy(sufferer));
		description = "TimeOut "; 
	}

	@Override
	public String getDescription() {
		return description + sufferer.getName();
	}

}
