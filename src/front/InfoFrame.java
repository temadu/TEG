package front;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.GameManager;

public class InfoFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1110, yOffset = 455;
	
	private static final int TEXT_GAP = -140;
	private static final int TEXT_SIZE = 13;
	
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
    	addTroop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().addTroop();
			}
		});
    	
    	name = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	name.setIconTextGap(TEXT_GAP);
		name.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
		
    	continent = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	continent.setIconTextGap(TEXT_GAP);
    	continent.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
    	
    	owner = new JLabel(new ImageIcon("assets/Fields/infoField.png"));
    	owner.setIconTextGap(TEXT_GAP);
    	owner.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
    	
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
    
    public void setName(String name) {
    	this.name.setText(name);
    }
    
    public void setOwner(String owner) {
    	this.owner.setText(owner);
    }
    
    public void setContinent(String continent) {
    	this.continent.setText(continent);
    }
    
    public void setTroopNumber(Integer troopNumber) {
    	this.troops.setText(troopNumber.toString());
    }
    
}
