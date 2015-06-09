package situations;

import situationStrategies.TimeOutAttackStrategy;
import assets.GameManager;
import assets.Player;

public class TimeOutSituation extends NoAttackSituation {
	
	private Player sufferer;

	public TimeOutSituation() {
		sufferer = GameManager.getInstance().getRandomPlayer();
		super.setAttackStrategy(new TimeOutAttackStrategy(sufferer));
	}

	@Override
	public String getDescription() {
		return null;
	}

}
