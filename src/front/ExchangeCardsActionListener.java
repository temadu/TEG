package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;
import assets.TEGException;

public class ExchangeCardsActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent a) {
		
		try {
			GameManager.getInstance().exchangeCards(TEGWindow.getInstance().getCardsFrame().getCardsNames());
			TEGWindow.getInstance().getCardsFrame().graphicUpdate();
			TEGWindow.getInstance().getPlayersFrame().graphicUpdate();
		} catch (TEGException e) {
			
		}
		
	}

	
	
}
