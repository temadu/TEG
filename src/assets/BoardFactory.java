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

public class BoardFactory {
	
	private static Sheet mapDataSheet;
	private static int countriesNum;
	private static int continentsNum;
	private static ArrayList<Country> countries;
	private static boolean[][] adjacentMatrix;
	private static HashMap<String, Continent> continents;
	
	
	public static Board boardCreator(String mapDataOrigin){
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
	
	private static ArrayList<Country> countryCreator(){
		ArrayList<Country> countries = new ArrayList<Country>();
		Cell workingCell;
		for (int i = 0; i < countriesNum; i++) {
			workingCell = mapDataSheet.getCell( 0 , 4+i);
			String countryName = workingCell.getContents();
			countries.add(new Country(countryName));
		}
		return countries;
	}
	
	private static boolean[][] adjacentCountriesMatrixCreator(){
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
	
	private static int getCountriesNum(){
		Cell countriesNumberCell = mapDataSheet.getCell(1, 0);
		return Integer.parseInt(countriesNumberCell.getContents());
	}
	
	private static HashMap<String, Continent> continentMapCreator(){
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
			System.out.println("Continente: " + continentName + ". PaisesNum: " + continentCountriesNum + ". Soldados: " + soldiersForConqueror + ".");

			HashSet<Country> countries = new HashSet<Country>();
			for (int j = 0; j < continentCountriesNum; j++) {
				workingCell = mapDataSheet.getCell(3 + j, 3 + countriesNum + 3 + i);
				String countryName = workingCell.getContents();
				countries.add(findCountry(countryName));
				System.out.println("numero de paises: " + countries.size());
				System.out.println("");

			}
			continents.put(continentName, new Continent(continentName, countries, continentCountriesNum, soldiersForConqueror));
		}
		return continents;
	}
	
	//TODO: EXCEPTION???
	private static Country findCountry(String countryName){
		for (Country each : countries) {
			if(each.getName().equals(countryName)){
				System.out.println("adding " + each.getName());
				return each;
			}
		}
		return null;
	}
	

}
