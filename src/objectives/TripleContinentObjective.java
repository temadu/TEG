package objectives;

import backend.Continent;

public class TripleContinentObjective extends ConquerorObjective {

	public TripleContinentObjective() {
		super.setDescription("Conquistar Gilacia, Arlas y Algos");
	}
	
	@Override
	public boolean checkObjective() {
		return ((intersectionNumber(Continent.GILACIA) == super.GILACIACOUNTRIESNUM) &&
				(intersectionNumber(Continent.ARLAS) >= super.ARLASCOUNTRIESNUM) &&
				(intersectionNumber(Continent.ALGOS) >= super.ALGOSCOUNTRIESNUM));
	}

}
