package situationStrategies;

import assets.GameManager;
import assets.Player;

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
