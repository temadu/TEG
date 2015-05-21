package backend;


public class Country {
	
	private String name;
	private int soldiers;
	private Player owner;
	
	public Country(String name) {
		this.name = name;
		this.soldiers = 1;
	}

	public boolean attack(Country enemy){
		if(this.soldiers == 1)
			return false;
		if(enemy.getOwner().equals(this.owner))
			return false;
		if(!GameManager.getInstance().getGameBox().getBoard().adjacentCountries(this, enemy))
			return false;
		Battle.conflict(this, enemy);
		return true;
	}
	
	public boolean killSoldiers(int kills){
		if(kills >= soldiers){
			soldiers = 1;
			return true;
		}	
		this.soldiers -= kills;
		return false;
	}
	
	public void changeOwner(Player newOwner){
		owner.removeCountry(this);
		owner = newOwner;
		owner.addCountry(this);
	}
	
	public Continent getContinent(){
		return GameManager.getInstance().getGameBox().getBoard().continentContainer(this);
	}
	
	
	///////////////////////////
	/////Getters & Setters/////
	///////////////////////////
	
	public String getName() {
		return name;
	}

	public int getSoldiers() {
		return soldiers;
	}
	
	public Player getOwner() {
		return owner;
	}

}
