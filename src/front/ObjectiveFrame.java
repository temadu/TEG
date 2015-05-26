package front;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class ObjectiveFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 535;
    
    public ObjectiveFrame() {
        super("Objective", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(300,172);

        //Set the window's location.
        setLocation(xOffset, yOffset);
		
    }
	
    private void createComponents() {
    	

    	
    }
    
}
