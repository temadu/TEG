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

public class SelectionFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 345;
	
	private static final int TEXT_GAP = -126;
	private static final int TEXT_SIZE = 12;
	
	private static final int WINDOW_HEIGHT = 180;
	private static final int WINDOW_WIDTH = 300;
	
	private static final int LAYOUT_ROWS = 3;
	private static final int LAYOUT_COLS = 2;
	private static final int LAYOUT_GAPS = 5;
	
	private JPanel panel;
    private JLabel from, to;
    private JButton attack,moveTroop;
    
    public SelectionFrame() {
        super("Selection", 
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
        setFrameIcon(new ImageIcon("assets/Icons/selection.png"));
		
    }
	
    private void createComponents() {
    	
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(LAYOUT_ROWS,LAYOUT_COLS,LAYOUT_GAPS,LAYOUT_GAPS));
    	
    	from = new JLabel(new ImageIcon("assets/Fields/FromToField.png"));
    	from.setIconTextGap(TEXT_GAP);
    	from.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
    	
    	to = new JLabel(new ImageIcon("assets/Fields/FromToField.png"));
    	to.setIconTextGap(TEXT_GAP);
    	to.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE));
    	
    	attack = new JButton("Attack", new ImageIcon("assets/Icons/attack.png"));
    	attack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent a) {
	
				GameManager.getInstance().attack();
			}
    		
    	});
    	
    	moveTroop = new JButton("Move", new ImageIcon("assets/Icons/move.png"));
    	moveTroop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent a) {
	

				
			}
    		
    	});
    	
    	panel.add(new JLabel("From:"));
    	panel.add(from);
    	panel.add(new JLabel("To:"));
    	panel.add(to);
    	panel.add(attack);
    	panel.add(moveTroop);
    	
    	add(panel);
    	
    }
    
    // Print attacking country name
    public void setFrom(String from) {
    	this.from.setText(from);
    }
    
    // Print defending country name
    public void setTo(String to) {
    	this.to.setText(to);
    }
    
}
