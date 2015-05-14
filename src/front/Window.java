package front;
import java.awt.EventQueue;
import javax.swing.*;

public class Window {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu gameMenu, showMenu, actionMenu, helpMenu;
	
	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
					window.frame.setJMenuBar(window.menuBar);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application
	public Window() {
		initialize();
	}

	//Initialize the contents of the frame
	private void initialize() {
		
		//Create the frame.
		frame = new JFrame();
		frame.setBounds(0, 0, 1024,768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("TEG");
		
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the game menu.
		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		gameMenu.add(new JMenuItem("New Game"));
		gameMenu.add(new JMenuItem("Load Game"));
		gameMenu.add(new JMenuItem("Save Game"));
		gameMenu.add(new JMenuItem("End Game"));
		gameMenu.add(new ExitMenuItem());
		
		//Build the show menu.
		showMenu = new JMenu("Show");
		menuBar.add(showMenu);
		showMenu.add(new JMenuItem("Map"));
		showMenu.add(new JMenuItem("Players"));
		showMenu.add(new JMenuItem("Selection"));
		showMenu.add(new JMenuItem("Dice"));
		showMenu.add(new JMenuItem("Objective"));
		showMenu.add(new JMenuItem("My Cards"));
		
		//Build the action menu.
		actionMenu = new JMenu("Action");
		menuBar.add(actionMenu);
		actionMenu.add(new JMenuItem("Add troop"));
		actionMenu.add(new JMenuItem("Attack"));
		actionMenu.add(new JMenuItem("Move troop"));
		actionMenu.add(new JMenuItem("Take card"));
		actionMenu.add(new JMenuItem("End turn"));
		
		//Build the help menu.
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		helpMenu.add(new JMenuItem("Rules"));
		
	}

}
;;