package situations;

import situationStrategies.CrisisTakeCardStrategy;
import situationStrategies.NormalTakeCardStrategy;
import situationStrategies.TakeCardStrategy;
import assets.GameManager;
import assets.Player;

/**
 * Situation that prohibits a random player to take card.
 * Changes the TakeCardStrategy in GameManager.
 */
public class CrisisSituation implements Situation {
	
	private TakeCardStrategy normalStrategy;
	private Player sufferer;
	private String description;
	
	public CrisisSituation() {
		normalStrategy = new NormalTakeCardStrategy();
		description = "Crisis ";
	}
	
	@Override
	public void situationStart() {
		sufferer = GameManager.getInstance().getRandomPlayer();
		GameManager.getInstance().setCardStrategy(new CrisisTakeCardStrategy(sufferer));
	}

	@Override
	public void situationEnd() {
		GameManager.getInstance().setCardStrategy(normalStrategy);
	}

	@Override
	public String getDescription() {
		return description + sufferer.getColor();
	}

}
