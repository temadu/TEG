package situations;

// Simple Situation where no special rules are in place.
public class NormalSituation implements Situation {

	private static final long serialVersionUID = 1L;
	
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
