package situationStrategies;

import java.io.Serializable;
import assets.GameManager;
import assets.Player;

// Strategy that prohibits any form of attack from a certain player..
public class TimeOutAttackStrategy implements AttackStrategy, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Player sufferer;
	
	public TimeOutAttackStrategy(Player sufferer) {
		this.sufferer = sufferer;
	}

	@Override
	public boolean AttackCheck() {
		return !sufferer.equals(GameManager.getInstance().getTurnPlayer());
	}

}
