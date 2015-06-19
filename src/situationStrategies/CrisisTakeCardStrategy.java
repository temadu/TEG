package situationStrategies;

import java.io.Serializable;

import assets.GameManager;
import assets.Player;

/**
 * Strategy that doesn't let a certain player to takeCard.
 */
public class CrisisTakeCardStrategy implements TakeCardStrategy,Serializable {

	private static final long serialVersionUID = 1L;
	
	private Player sufferer;
	
	public CrisisTakeCardStrategy(Player sufferer) {
		this.sufferer = sufferer;
	}

	@Override
	public boolean cardTakeCheck() {
		return !sufferer.equals(GameManager.getInstance().getTurnPlayer());
	}

}
