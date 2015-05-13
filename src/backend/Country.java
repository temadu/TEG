package backend;

public class Country {
	
	private String name;
	private int soldiers;
	private Player owner;
	
	public Country(String name) {
		this.name = name;
		this.soldiers = 1;
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

}
