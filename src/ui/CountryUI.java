package ui;

/**
 * UI counterpart the the Country class in the backend.
 * Created and Edited by the CountryHandler observer.
 * Access for reading to the frontend (Swing).
 */

public class CountryUI {

	private String name;
	private int soldiers;
	private String owner;
	private String continent;
	
	
	public CountryUI(String name) {
		this.name = name;
		this.soldiers = 1;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
