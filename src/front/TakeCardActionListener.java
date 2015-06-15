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
		} catch (TEGException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
