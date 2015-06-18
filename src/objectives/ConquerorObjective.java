package objectives;

import assets.Board;
import assets.Continent;
import assets.GameManager;

/**
 * Abstract Objective that provides functionality for Objective subclasses that are about 
 * conquering some continents or some countries form different continents.
 * For easier and faster creation of objectives.
 */

public abstract class ConquerorObjective extends Objective {
	
	private static final long serialVersionUID = 1L;
	
	private static Board board = GameManager.getInstance().getGameBox().getBoard();
	private final static String SCHATARIA = "Schataria";
	private final static String ARILLIA = "Arillia";
	private final static String URZA = "Urza";
	private final static String GILACIA = "Gilacia";
	private final static String ARLAS = "Arlas";
	private final static String ALGOS = "Algos";
	
	@Override
	public abstract boolean checkSpecificObjective();

	protected Continent getSchataria() {
		return board.getContinent(SCHATARIA);
	}

	protected Continent getArillia() {
		return board.getContinent(ARILLIA);
	}

	protected Continent getUrza() {
		return board.getContinent(URZA);
	}

	protected Continent getGilacia() {
		return board.getContinent(GILACIA);
	}

	protected Continent getArlas() {
		return board.getContinent(ARLAS);
	}

	protected Continent getAlgos() {
		return board.getContinent(ALGOS);
	}

}
