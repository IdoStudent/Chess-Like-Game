package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.MenuAction;
import Model.GameEngine;

public class Menu {
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem addPlayerItem;
	
	public Menu(GameEngine gameEngine) {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		addPlayerItem = new JMenuItem("Add Player");
		fileMenu.add(addPlayerItem);
		addPlayerItem.addActionListener(new MenuAction(gameEngine));
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
}
