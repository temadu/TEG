package situations;

import situationStrategies.CrisisTakeCardStrategy;
import situationStrategies.NormalTakeCardStrategy;
import situationStrategies.TakeCardStrategy;
import assets.GameManager;
import assets.Player;

public class CrisisSituation implements Situation {
	
	private TakeCardStrategy normalStrategy;
	private Player sufferer;
	
	public CrisisSituation() {
		normalStrategy = new NormalTakeCardStrategy();
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
		return null;
	}

}
