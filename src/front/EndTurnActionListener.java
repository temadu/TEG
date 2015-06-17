package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;
import assets.TEGException;

public class EndTurnActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			GameManager.getInstance().changeTurn();
			// Graphic update.
			TEGWindow.getInstance().getPlayersFrame().graphicUpdate();
			TEGWindow.getInstance().getSituationFrame().graphicUpdate();
			TEGWindow.getInstance().getObjectiveFrame().graphicUpdate();
			TEGWindow.getInstance().getWinnerFrame().graphicUpdate();
			TEGWindow.getInstance().getCardsFrame().graphicUpdate();
			TEGWindow.getInstance().getConsoleFrame().graphicUpdate();
		} catch(TEGException e) {

		}
		
	}
	
}
