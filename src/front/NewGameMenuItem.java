package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class NewGameMenuItem extends JMenuItem {

	public NewGameMenuItem() {
		
		setText("New Game");
		addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				
				// PREGUNTAR!!!!!!!!!!!!!!!!!! ESTOY MEZCLANDO GRAFICO/MANEJO DE DATOS ???????????????????????
				
				GameManager.getInstance().newGame();
				TEGWindow.getInstance().createNewGameWindow();
				
			}
			
		});
		
	}
	
}
