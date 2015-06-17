package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;
import assets.TEGException;

public class AttackActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			TEGWindow.getInstance().getDiceFrame().updateNames();
			GameManager.getInstance().attack();
			TEGWindow.getInstance().getDiceFrame().graphicUpdate();
			TEGWindow.getInstance().getMapFrame().getPanel().graphicUpdate();
			TEGWindow.getInstance().getPlayersFrame().graphicUpdate();
			TEGWindow.getInstance().getInfoFrame().graphicUpdate();
			TEGWindow.getInstance().getConsoleFrame().graphicUpdate();
		} catch(TEGException e) {

		}
		
	}

	
	
}
