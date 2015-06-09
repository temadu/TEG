package situationStrategies;

import assets.GameManager;
import assets.Player;

public class TimeOutAttackStrategy implements AttackStrategy {
	
	private Player sufferer;
	
	public TimeOutAttackStrategy(Player sufferer) {
		this.sufferer = sufferer;
	}

	@Override
	public boolean AttackCheck() {
		return !sufferer.equals(GameManager.getInstance().getTurnPlayer());
	}

}
