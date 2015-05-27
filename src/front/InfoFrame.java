package front;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1175, yOffset = 455;
	
    private JPanel panel;
    private JLabel name, continent, owner, troops;
    private JButton addTroop;
    
    public InfoFrame() {
        super("Country Information", 
              false, //resizable
              true, //closable
              false, //maximizable
              false);//iconifiable
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        //...Create the GUI and put it in the window...
        createComponents();
        
        //...Then set the window size or call pack...
        setSize(175,252);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/info.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(9,1,20,2));
    	
    	addTroop = new JButton("Add Troop",new ImageIcon("assets/Icons/add.png"));
    	
    	name = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	continent = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	owner = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	troops = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	
    	panel.add(new JLabel("Name:"));
    	panel.add(name);
    	panel.add(new JLabel("Continent:"));
    	panel.add(continent);
    	panel.add(new JLabel("Owner:"));
    	panel.add(owner);
    	panel.add(new JLabel("Troops:"));
    	panel.add(troops);
    	panel.add(addTroop);
    	
    	add(panel);
    	
    }
    
}
