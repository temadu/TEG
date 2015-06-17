package front;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsoleFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 535;
	
	private static final int WINDOW_HEIGHT = 250;
	private static final int WINDOW_WIDTH = 500;
	
	private static final int MAX_LINES = 50;
	
	private int lineCount;
	private String console;
    
	private JScrollPane scroll;
	private JTextArea text;
	 
	public ConsoleFrame() {
		super(	"Console", 
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
		setFrameIcon(new ImageIcon("assets/Icons/console.png"));
	        
	}
		
	private void createComponents() {
	    
		text = new JTextArea(MAX_LINES,MAX_LINES);
		 
		scroll = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		text.setBackground(new Color(136,29,4));
		text.setForeground(Color.white);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		
		lineCount = 0;
		
		add(scroll);
	    	
	}
	 
	public void addLine(String line) {
		
		lineCount++;
		if(lineCount >= MAX_LINES) {
			deleteFirstLine();
		}
		console += "\n"+line;
		text.setText(console);
			
	}
	
	private void deleteFirstLine() {
		
		String temp = console.replaceFirst("\n", "");
		int index = temp.indexOf("\n");
		console = temp.substring(index+1);
		
	}

	@Override
	public void graphicUpdate() {
		// TODO Auto-generated method stub
		
	}
	
}
