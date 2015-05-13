package objectives;

import backend.Player;

public abstract class Objective {
	
	private static final int COUNTRIESTOCONQUER = 30;
	private Player owner;
	
	public boolean generalObjectiveCheck(){
		return ((owner.countriesNumber() >= COUNTRIESTOCONQUER) ? true : false);
	}
	
	public abstract boolean checkObjective();

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
