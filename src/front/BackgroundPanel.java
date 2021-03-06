package front;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image bg;

	public BackgroundPanel() {

		bg = new ImageIcon("assets/Background/bg.png").getImage();
		setLayout(null);
		
	}
	    
	@Override
	public void paintComponent(Graphics g) {

		// Draw the background
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

	}

}
