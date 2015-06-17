package front;

import io.GameIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import assets.GameManager;

public class TegMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;

	private JMenu gameMenu, showMenu, actionMenu, helpMenu;
	
	private boolean newGameEnabled = true;
	private boolean loadGameEnabled = true;
	private boolean endGameEnabled = false;
	private boolean saveGameEnabled = false;
	
	public TegMenu() {
		
		createGameMenu();
		createShowMenu();
		createActionMenu();
		createHelpMenu();
		
	}
	
	public void createGameMenu() {
		
		JMenuItem exit,newGame, saveGame, loadGame, endGame;
		
		endGame = new JMenuItem("End Game");
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(TEGWindow.getInstance().getMenu().isNewGameEnabled()) {
					TEGWindow.getInstance().getMenu().setNewGameEnabled(false);
					GameManager.getInstance().newGame();
					TEGWindow.getInstance().createNewGameWindow();
				}
			}
			
		});
		
		saveGame = new JMenuItem("Save Game");
		saveGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(TEGWindow.getInstance().getMenu().isSaveGameEnabled()) {
					GameIO.setGame(GameManager.getInstance());
					GameIO.saveGame();
				}
			}
		});

		loadGame = new JMenuItem("Load Game");
		loadGame.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(TEGWindow.getInstance().getMenu().isLoadGameEnabled())
					GameIO.loadGame();
			}
		});
		
		gameMenu = new JMenu("Game");
		add(gameMenu);
		gameMenu.add(newGame);
		gameMenu.add(loadGame);
		gameMenu.add(saveGame);
		gameMenu.add(endGame);
		gameMenu.add(exit);
		
	}
	
	@SuppressWarnings("deprecation")
	public void createShowMenu() {
		
		JMenuItem 	showMap, showPlayers, showSelection, showDice,
					showObjective, showCards, showSituation,
					showCountryInfo, showConsole;
		
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
		
		showConsole = new JMenuItem("Console");
		showConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TEGWindow.getInstance().getConsoleFrame().setVisible(true);
			}
		});

		showMenu = new JMenu("Show");
		showMenu.disable();
		add(showMenu);
		showMenu.add(showMap);
		showMenu.add(showPlayers);
		showMenu.add(showSelection);
		showMenu.add(showDice);
		showMenu.add(showObjective);
		showMenu.add(showCards);
		showMenu.add(showSituation);
		showMenu.add(showCountryInfo);
		showMenu.add(showConsole);
		
	}
	
	@SuppressWarnings("deprecation")
	public void createActionMenu() {
		
		JMenuItem 	addTroop, attack, moveTroop, takeCard, endTurn;
		
		actionMenu = new JMenu("Action");
		actionMenu.disable();
		add(actionMenu);
		
		addTroop = new JMenuItem("Add troop");
		addTroop.addActionListener(new AddTroopActionListener());
		actionMenu.add(addTroop);
		
		attack = new JMenuItem("Attack");
		attack.addActionListener(new AttackActionListener());
		actionMenu.add(attack);
		
		moveTroop = new JMenuItem("Move troop");
		moveTroop.addActionListener(new MoveTroopActionListener());
		actionMenu.add(moveTroop);
		
		takeCard = new JMenuItem("Take card");
		takeCard.addActionListener(new TakeCardActionListener());
		actionMenu.add(takeCard);
		
		endTurn = new JMenuItem("End turn");
		endTurn.addActionListener(new EndTurnActionListener());
		actionMenu.add(endTurn);
		
	}
	
	public void createHelpMenu() {
		
		helpMenu = new JMenu("Help");
		add(helpMenu);
		helpMenu.add(new JMenuItem("How to Play?"));
		
	}

	public JMenu getGameMenu() {
		return gameMenu;
	}

	public JMenu getShowMenu() {
		return showMenu;
	}

	public JMenu getActionMenu() {
		return actionMenu;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public boolean isNewGameEnabled() {
		return newGameEnabled;
	}

	public void setNewGameEnabled(boolean newGameEnabled) {
		this.newGameEnabled = newGameEnabled;
	}

	public boolean isLoadGameEnabled() {
		return loadGameEnabled;
	}

	public void setLoadGameEnabled(boolean loadGameEnabled) {
		this.loadGameEnabled = loadGameEnabled;
	}

	public boolean isSaveGameEnabled() {
		return saveGameEnabled;
	}

	public void setSaveGameEnabled(boolean saveGameEnabled) {
		this.saveGameEnabled = saveGameEnabled;
	}

	public void setShowMenu(JMenu showMenu) {
		this.showMenu = showMenu;
	}

	public boolean isEndGameEnabled() {
		return endGameEnabled;
	}

	public void setEndGameEnabled(boolean endGameEnabled) {
		this.endGameEnabled = endGameEnabled;
	}

}
