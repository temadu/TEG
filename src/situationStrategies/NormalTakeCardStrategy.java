package situationStrategies;

/**
 * Strategy that lets any player to takeCard.
 */
public class NormalTakeCardStrategy implements TakeCardStrategy {

	@Override
	public boolean cardTakeCheck() {
		return true;
	}

}
