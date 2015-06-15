package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;
import assets.TEGException;

public class MoveTroopActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			GameManager.getInstance().moveSoldiers();
			TEGWindow.getInstance().getMapFrame().getPanel().graphicUpdate();	
		} catch(TEGException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
