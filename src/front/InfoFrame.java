package front;

import javax.swing.JInternalFrame;

public class InfoFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1175, yOffset = 455;
    
    public InfoFrame() {
        super("Country Information", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(175,252);

        //Set the window's location.
        setLocation(xOffset, yOffset);
		
    }
	
    private void createComponents() {
    	

    	
    }
    
}
