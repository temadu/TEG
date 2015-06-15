package front;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameUI;

public class DiceFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 1110, yOffset = 5;
	
	private static final int WINDOW_HEIGHT = 200;
	private static final int WINDOW_WIDTH = 175;
	
	private static final int LAYOUT_ROWS = 5;
	private static final int LAYOUT_COLS = 2;
	private static final int LAYOUT_GAPS = 5;
	
	private static final int MAX_NUM_OF_DICE = 4;
	
    private JPanel panel;

    private JLabel[] attackerDice;
    private JLabel[] defenderDice;
    private JLabel attackerName, defenderName;
    
    
    public DiceFrame() {
        super("Dice", 
              false, //resizable
              true,  //closable
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
        setFrameIcon(new ImageIcon("assets/Icons/dice.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	attackerDice = new JLabel[MAX_NUM_OF_DICE];
    	defenderDice = new JLabel[MAX_NUM_OF_DICE];
    	
    	attackerName = new JLabel();
    	attackerName.setHorizontalAlignment(JLabel.CENTER);
    	defenderName = new JLabel();
    	defenderName.setHorizontalAlignment(JLabel.CENTER);
    	
    	panel.add(attackerName);
    	panel.add(defenderName);
    	
    	for(int i = 0; i < MAX_NUM_OF_DICE; i++) {
    		
    		attackerDice[i] = new JLabel();
    		defenderDice[i] = new JLabel();
    		attackerDice[i].setHorizontalAlignment(JLabel.CENTER);
    		defenderDice[i].setHorizontalAlignment(JLabel.CENTER);
    		
    		panel.add(attackerDice[i]);
    		panel.add(defenderDice[i]);
    		
    	}
    	
    	add(panel);
    	
    }
    
    // Print attacker name
    public void setAttackerName(String name) {
    	attackerName.setText("<html>"+name+"</html>");
    }
    
    // Print defender name
    public void setDefenderName(String name) {
    	defenderName.setText("<html>"+name+"</html>");
    }
    
    // Print attacker's dice
    public void setAttackerDice(ArrayList<Integer> attackerDice) {
    	
    	int i = 0;
    	for(; i < attackerDice.size(); i++) {
    		Integer number = attackerDice.get(i);
    		this.attackerDice[i].setIcon(new ImageIcon("assets/Dice/" + number.toString() + ".png"));
    	}
    	for(; i < MAX_NUM_OF_DICE; i++) {
    		this.attackerDice[i].setIcon(null);
    	}
    	
    }
    
    // Print defender's dice
    public void setDefenderDice(ArrayList<Integer> defenderDice) {
    	
    	int i = 0;
    	for(; i < defenderDice.size(); i++) {
    		Integer number = defenderDice.get(i);
    		this.defenderDice[i].setIcon(new ImageIcon("assets/Dice/" + number.toString() + ".png"));
    	}
    	for(; i < MAX_NUM_OF_DICE; i++) {
    		this.defenderDice[i].setIcon(null);
    	}
    	
    }

	@Override
	public void graphicUpdate() {
		
		setAttackerDice(GameUI.getInstance().getDice().getAttackerDice());
		setDefenderDice(GameUI.getInstance().getDice().getDefenderDice());
		setAttackerName(GameUI.getInstance().getOwnerUI(GameUI.getInstance().getAttacker()).getName());
		setDefenderName(GameUI.getInstance().getOwnerUI(GameUI.getInstance().getDefender()).getName());
		
	}
    
}
