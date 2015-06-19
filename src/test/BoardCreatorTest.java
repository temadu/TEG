package test;

import org.junit.Assert;
import org.junit.Test;

import assets.Board;
import assets.BoardFactory;
import assets.Continent;
import assets.Country;

public class BoardCreatorTest {
	private Board board;

	@Test
	public void test() {
		board = BoardFactory.boardCreator("assets/tormap/torAdjacentMatrix.xls");
		Continent continent = board.getContinent("Urza");
		Assert.assertTrue(continent.getName().equals("Urza"));
		
		Country country1 = board.parseStringToCountry("Azealon");
		Country country2 = board.parseStringToCountry("Travaria");
		Assert.assertTrue("They are not adjacent", board.adjacentCountries(country1, country2));
		
		Assert.assertFalse("It should not attack", country1.attack(country2));
	}

}
