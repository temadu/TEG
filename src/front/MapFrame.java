package front;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class MapFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 305, yOffset = 5;
	private static final int WINDOW_WIDTH = 810, WINDOW_HEIGHT = 562;
    
	private MapPanel panel;
    
    public MapFrame() {
        super("Map", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        //Set the window's location.
        setLocation(xOffset,yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/map.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new MapPanel();
    	add(panel);
    	
    }

	public MapPanel getPanel() {
		return panel;
	}
    
}
