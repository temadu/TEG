package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import assets.GameManager;

public class TegMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;

	private JMenu gameMenu, showMenu, actionMenu, helpMenu;
	
	public TegMenu() {
		
		createGameMenu();
		createShowMenu();
		createActionMenu();
		createHelpMenu();
		
	}
	
	public void createGameMenu() {
		
		JMenuItem exit, newGame;
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				GameManager.getInstance().newGame();
				TEGWindow.getInstance().createNewGameWindow();
				
			}
			
		});

		gameMenu = new JMenu("Game");
		add(gameMenu);
		gameMenu.add(newGame);
		gameMenu.add(new JMenuItem("Load Game"));
		gameMenu.add(new JMenuItem("Save Game"));
		gameMenu.add(new JMenuItem("End Game"));
		gameMenu.add(exit);
		
	}
	
	public void createShowMenu() {
		
		JMenuItem 	showMap, showPlayers, showSelection, showDice,
					showObjective, showCards, showSituation,
					showCountryInfo;
		
		showMap = new JMenuItem("Map");
		showMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getMapFrame().setVisible(true);
			}
		});
		
		showPlayers = new JMenuItem("Players");
		showPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getPlayersFrame().setVisible(true);
			}
		});
		
		showSelection = new JMenuItem("Selection");
		showSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getSelectionFrame().setVisible(true);
			}
		});
		
		showDice = new JMenuItem("Dice");
		showDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getDiceFrame().setVisible(true);
			}
		});
		
		showObjective = new JMenuItem("Objective");
		showObjective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getObjectiveFrame().setVisible(true);
			}
		});
		
		showCards = new JMenuItem("My Cards");
		showCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getCardsFrame().setVisible(true);
			}
		});
		
		showSituation = new JMenuItem("Situation");
		showSituation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getSituationFrame().setVisible(true);
			}
		});
		
		showCountryInfo = new JMenuItem("Country Information");
		showCountryInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getInfoFrame().setVisible(true);
			}
		});

		showMenu = new JMenu("Show");
		add(showMenu);
		showMenu.add(showMap);
		showMenu.add(showPlayers);
		showMenu.add(showSelection);
		showMenu.add(showDice);
		showMenu.add(showObjective);
		showMenu.add(showCards);
		showMenu.add(showSituation);
		showMenu.add(showCountryInfo);
		
	}
	
	public void createActionMenu() {
		
		actionMenu = new JMenu("Action");
		add(actionMenu);
		actionMenu.add(new JMenuItem("Add troop"));
		actionMenu.add(new JMenuItem("Attack"));
		actionMenu.add(new JMenuItem("Move troop"));
		actionMenu.add(new JMenuItem("Take card"));
		actionMenu.add(new JMenuItem("End turn"));
		
	}
	
	public void createHelpMenu() {
		
		helpMenu = new JMenu("Help");
		add(helpMenu);
		helpMenu.add(new JMenuItem("Rules"));
		
	}

}
