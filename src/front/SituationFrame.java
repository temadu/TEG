package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameUI;

public class SituationFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1110, yOffset = 230;
	
	private static final int WINDOW_HEIGHT = 200;
	private static final int WINDOW_WIDTH = 175;
	
	private static final int LAYOUT_ROWS = 1;
	private static final int LAYOUT_COLS = 1;
	private static final int LAYOUT_GAPS = 0;
    
    private JPanel panel;
	private JLabel situation;
    
    public SituationFrame() {
        super("Situation", 
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
        setLocation(xOffset, yOffset);
		
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/situation.png"));
        
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	situation = new JLabel();
    	
    	panel.add(situation);
    	
    	changeSituation(GameUI.getInstance().getSituation());

    	add(panel);
    	
    }
    
    // Print situation card
    public void changeSituation(String situation) {
    	
    	if(situation == null)
    		this.situation.setIcon(null);
    	else {
    		// Fix the string in order to get the image
    		String str = situation.toLowerCase().replaceAll("\\s+","_");
    		this.situation.setIcon(new ImageIcon("assets/Situation/" + str + ".png"));
    		
    	}
    	
    }
    
}
