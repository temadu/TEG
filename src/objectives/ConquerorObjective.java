package objectives;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import backend.Board;
import backend.Continent;
import backend.Country;
import backend.GameBox;

public abstract class ConquerorObjective extends Objective {
	
	protected static final int SHATARIACOUNTRIESNUM = 9;
	protected static final int ARILLIACOUNTRIESNUM = 12;
	protected static final int URZACOUNTRIESNUM = 7;
	protected static final int GILACIACOUNTRIESNUM = 4;
	protected static final int ARLASCOUNTRIESNUM = 6;
	protected static final int ALGOSCOUNTRIESNUM = 4;
	
	private Board board;
	private Set<Country> playerCountries;
	
	public ConquerorObjective() {
		this.board = GameBox.getInstance().getBoard();
		this.playerCountries = getOwner().getCountries();
	}
	
	protected int intersectionNumber(Continent continent){
		Set<Country> continentCountries = board.getContinent(continent);
		int i = 0;
		for (Country country : continentCountries) {
			if(playerCountries.contains(country))
				i++;
		}
		return i;
	}

	@Override
	public abstract boolean checkObjective();

}
