package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;
import assets.TEGException;

public class TakeCardActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent a) {
		
		try {
			GameManager.getInstance().takeCard();
			TEGWindow.getInstance().getCardsFrame().graphicUpdate();
			
			TEGWindow.getInstance().getPlayersFrame().graphicUpdate();
			TEGWindow.getInstance().getSituationFrame().graphicUpdate();
			TEGWindow.getInstance().getObjectiveFrame().graphicUpdate();
			TEGWindow.getInstance().getWinnerFrame().graphicUpdate();
		} catch (TEGException e) {

		}
		
	}

	
	
}
