package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;

public class EndTurnActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GameManager.getInstance().changeTurn();
		
		// Graphic update.
		TEGWindow.getInstance().getPlayersFrame().graphicUpdate();
		TEGWindow.getInstance().getSituationFrame().graphicUpdate();
		TEGWindow.getInstance().getObjectiveFrame().graphicUpdate();
		
	}

	
	
}
