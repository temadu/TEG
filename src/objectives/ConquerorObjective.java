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
	
	private static Board board = GameManager.getInstance().getGameBox().getBoard();
	private static String schataria = "Schataria";
	private static String arillia = "Arillia";
	private static String urza = "Urza";
	private static String gilacia = "Gilacia";
	private static String arlas = "Arlas";
	private static String algos = "Algos";
	
	@Override
	public abstract boolean checkSpecificObjective();

	protected Continent getSchataria() {
		return board.getContinent(schataria);
	}

	protected Continent getArillia() {
		return board.getContinent(arillia);
	}

	protected Continent getUrza() {
		return board.getContinent(urza);
	}

	protected Continent getGilacia() {
		return board.getContinent(gilacia);
	}

	protected Continent getArlas() {
		return board.getContinent(arlas);
	}

	protected Continent getAlgos() {
		return board.getContinent(algos);
	}
	
	

}
