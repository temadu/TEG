package front;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1110, yOffset = 455;
	
	private static final int TEXT_GAP = -140;
	private static final int TEXT_SIZE = 13;
	
	private static final int WINDOW_HEIGHT = 252;
	private static final int WINDOW_WIDTH = 175;
	
	private static final int LAYOUT_ROWS = 9;
	private static final int LAYOUT_COLS = 1;
	private static final int LAYOUT_GAPS = 0;
	
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
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        //Set the window's location.
        setLocation(xOffset, yOffset);
        
        // Set the icon
        setFrameIcon(new ImageIcon("assets/Icons/info.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	addTroop = new JButton("Add Troop");
    	addTroop.addActionListener(new AddTroopActionListener());
    	
    	name = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	name.setIconTextGap(TEXT_GAP);
		name.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
		
    	continent = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	continent.setIconTextGap(TEXT_GAP);
    	continent.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
    	
    	owner = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	owner.setIconTextGap(TEXT_GAP);
    	owner.setFont(new Font(Font.SANS_SERIF, Font.BOLD, TEXT_SIZE+1));
    	
    	troops = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	troops.setIconTextGap(TEXT_GAP);
    	troops.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
    	
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
    
    // Print country name
    public void setName(String name) {
    	this.name.setText(name);
    }
    
    // Print country ownter
    public void setOwner(String owner) {
    	this.owner.setText(owner);
    }
    
    // Print country continent
    public void setContinent(String continent) {
    	this.continent.setText(continent);
    }
    
    // Print country number of troops
    public void setTroopNumber(Integer troopNumber) {
    	this.troops.setText(troopNumber.toString());
    }

	public JLabel getCountryNameLabel() {
		return name;
	}
    
}
