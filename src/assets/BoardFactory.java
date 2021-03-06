package assets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * A Factory that creates a board from a spreadsheet.
 */
public abstract class BoardFactory {
	
	private static Sheet mapDataSheet;
	private static int countriesNum;
	private static int continentsNum;
	private static ArrayList<Country> countries;
	private static boolean[][] adjacentMatrix;
	private static HashMap<String, Continent> continents;
	
	/**
	 * The factory method that creates a board from a spreadsheet.
	 * @param mapDataOrigin The spreadsheet's location.
	 * @return 
	 */
	public static Board boardCreator(String mapDataOrigin) {
		
		try {
		
			Workbook workbook = Workbook.getWorkbook(new File(mapDataOrigin));
			mapDataSheet = workbook.getSheet(0);
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		countriesNum = getCountriesNum();
		countries = countryCreator();
		adjacentMatrix = adjacentCountriesMatrixCreator();
		continents = continentMapCreator();
		
		return new Board(countriesNum, continents, countries, adjacentMatrix);
		
	}
	
	/**
	 * Creates an ArrayList of countries from the spreadsheet.
	 * @return
	 */
	private static ArrayList<Country> countryCreator() {
		
		ArrayList<Country> countries = new ArrayList<Country>();
		Cell workingCell;
		
		for (int i = 0; i < countriesNum; i++) {
			workingCell = mapDataSheet.getCell( 0 , 4+i);
			String countryName = workingCell.getContents();
			countries.add(new Country(countryName));
		}
		
		return countries;
		
	}
	
	/**
	 * Creates an adjacent matrix of booleans that represents the neighbouring countries.
	 * @return
	 */
	private static boolean[][] adjacentCountriesMatrixCreator() {
		
		boolean[][] adjacentMatrix = new boolean[countriesNum][countriesNum];
		Cell workingCell;
		
		for (int i = 0; i < countriesNum; i++) {
			for (int j = 0; j < countriesNum; j++) {
				workingCell = mapDataSheet.getCell( 1+i , 4+j);
				if(workingCell.getContents().equals("1"))
					adjacentMatrix[i][j] = true;
				else
					adjacentMatrix[i][j] = false;
			}
		}
		
		return adjacentMatrix;
	}
	
	private static int getCountriesNum() {
		
		Cell countriesNumberCell = mapDataSheet.getCell(1, 0);
		
		return Integer.parseInt(countriesNumberCell.getContents());
		
	}
	
	/**
	 * Creates a HashMap from the name of the continent to the continent.
	 * @return
	 */
	private static HashMap<String, Continent> continentMapCreator() {
		
		HashMap<String, Continent> continents = new HashMap<>();
		Cell workingCell;
		continentsNum =  Integer.parseInt(mapDataSheet.getCell(1, 1).getContents());
		
		for (int i = 0; i < continentsNum; i++) {
			
			workingCell = mapDataSheet.getCell(0, 3 + countriesNum + 3 + i);
			String continentName = workingCell.getContents();
			
			workingCell = mapDataSheet.getCell(1, 3 + countriesNum + 3 + i);
			int continentCountriesNum = Integer.parseInt(workingCell.getContents());
			
			workingCell = mapDataSheet.getCell(2, 3 + countriesNum + 3 + i);
			int soldiersForConqueror = Integer.parseInt(workingCell.getContents());

			HashSet<Country> countries = new HashSet<Country>();
			for (int j = 0; j < continentCountriesNum; j++) {
				workingCell = mapDataSheet.getCell(3 + j, 3 + countriesNum + 3 + i);
				String countryName = workingCell.getContents();
				countries.add(findCountry(countryName));

			}
			continents.put(continentName, new Continent(continentName, countries, continentCountriesNum, soldiersForConqueror));
		}
		
		return continents;
		
	}
	
	/**
	 * Finds a country from his name.
	 * @param countryName
	 * @return
	 */
	private static Country findCountry(String countryName) {
		
		for (Country each : countries) {
			if(each.getName().equals(countryName))
				return each;
		}
		
		return null;
		
	}

}
