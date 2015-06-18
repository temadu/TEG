package situationStrategies;

import java.io.Serializable;

/**
 * Strategy that lets any player to takeCard.
 */
public class NormalTakeCardStrategy implements TakeCardStrategy, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean cardTakeCheck() {
		return true;
	}

}
