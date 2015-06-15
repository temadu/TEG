package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;

public class TakeCardActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent a) {
		
		GameManager.getInstance().takeCard();
		TEGWindow.getInstance().getCardsFrame().graphicUpdate();
		
	}

	
	
}
