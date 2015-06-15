package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assets.GameManager;

public class MoveTroopActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GameManager.getInstance().moveSoldiers();
		TEGWindow.getInstance().getMapFrame().getPanel().graphicUpdate();
		
	}

	
	
}
