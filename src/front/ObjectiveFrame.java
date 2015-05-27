package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ObjectiveFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 535;
	
    private JPanel panel;
    private JLabel objective;
    
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
		
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/objective.png"));
        
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(1,1,0,0));
    	
    	objective = new JLabel(new ImageIcon("assets/Fields/ObjectiveField.png"));

    	panel.add(objective);
    	
    	add(panel);
    	
    }
    
}
