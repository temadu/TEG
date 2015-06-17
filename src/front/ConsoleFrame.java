package front;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import assets.Console;
import ui.GameUI;

public class ConsoleFrame extends JInternalFrame implements GraphicUpdate {

	private static final long serialVersionUID = 1L;

	private static final int xOffset = 5, yOffset = 535;
	
	private static final int WINDOW_HEIGHT = 250;
	private static final int WINDOW_WIDTH = 500;
	
	private int lineCount;
	private String console = "";
    
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
	    
		text = new JTextArea(Console.LINES,Console.LINES);
		 
		scroll = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		text.setBackground(new Color(45,10,34));
		text.setForeground(Color.white);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.setText("");
		
		lineCount = 0;
		
		add(scroll);
	    	
	}
	 
	public void addLine(String line) {
		
		lineCount++;
		console += "\n"+line;
		text.setText(console.substring(1));
			
	}
	
	private void deleteFirstLine() {
		
		String temp = console.replaceFirst("\n", "");
		int index = temp.indexOf("\n");
		console = temp.substring(index);
		lineCount--;
		
	}

	@Override
	public void graphicUpdate() {
		
		if(lineCount == Console.LINES)
			deleteFirstLine();
		
		for(int i = lineCount; i < GameUI.getInstance().getConsole().getConsole().size(); i++)
			addLine(GameUI.getInstance().getConsole().getConsole().get(i));
		
	}
	
}
