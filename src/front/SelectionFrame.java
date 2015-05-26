package front;

import javax.swing.JInternalFrame;

public class SelectionFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 360;
    
    public SelectionFrame() {
        super("Selection", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(300,150);

        //Set the window's location.
        setLocation(xOffset, yOffset);
		
    }
	
    private void createComponents() {
    	

    	
    }
    
}
