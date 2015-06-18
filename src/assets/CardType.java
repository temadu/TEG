package assets;

public enum CardType {
	
	SHIP, BALLOON, TANK;
	
	public static boolean cardExchangeCheck(CardType a, CardType b, CardType c){
		
		if((a == b) && (a == c))
			return true;
		
		if((a != b) && (a != c) && (b != c))
			return true;
		
		return false;
	
	}
	
}
