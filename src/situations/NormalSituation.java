package situations;

/**
 * Simple Situation where no special rules are in place.
 */
public class NormalSituation implements Situation {

	@Override
	public void situationStart() {
	}

	@Override
	public void situationEnd() {
	}

	@Override
	public String getDescription() {
		return "Normal";
	}

}
