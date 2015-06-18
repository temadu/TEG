package situationStrategies;

import assets.GameManager;
import assets.Player;
/**
 * Strategy that doesn't let a certain player to takeCard.
 */
public class CrisisTakeCardStrategy implements TakeCardStrategy {

	private Player sufferer;
	
	public CrisisTakeCardStrategy(Player sufferer) {
		this.sufferer = sufferer;
	}

	@Override
	public boolean cardTakeCheck() {
		return !sufferer.equals(GameManager.getInstance().getTurnPlayer());
	}

}
