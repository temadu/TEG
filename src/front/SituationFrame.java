package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SituationFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1175, yOffset = 230;
    
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
        setSize(175,200);

        //Set the window's location.
        setLocation(xOffset, yOffset);
		
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/situation.png"));
        
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(1,1,20,10));
    	
    	situation = new JLabel(new ImageIcon("assets/Situation/snow.png"));
    	
    	panel.add(situation);

    	add(panel);
    	
    }
    
}
