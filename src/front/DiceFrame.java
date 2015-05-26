package front;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class DiceFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1175, yOffset = 5;
    
    public DiceFrame() {
        super("Dice", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(175,200);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/dice.png"));
		
    }
	
    private void createComponents() {
    	

    	
    }
    
}
