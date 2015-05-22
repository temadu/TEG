package objectives;

import assets.Continent;

public abstract class ConquerorObjective extends Objective {
	
	private static Continent shataria;
	private static Continent arillia;
	private static Continent urza;
	private static Continent gilacia;
	private static Continent arlas;
	private static Continent algos;
	
	@Override
	public abstract boolean checkObjective();

	public static Continent getShataria() {
		return shataria;
	}

	public static Continent getArillia() {
		return arillia;
	}

	public static Continent getUrza() {
		return urza;
	}

	public static Continent getGilacia() {
		return gilacia;
	}

	public static Continent getArlas() {
		return arlas;
	}

	public static Continent getAlgos() {
		return algos;
	}
	
	

}
