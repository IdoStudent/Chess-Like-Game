package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.GameEngine;
import Model.Player;

public class MenuAction implements ActionListener{
	
	GameEngine gameEngine;
	
	public MenuAction(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		gameEngine.createNewPlayer();
	}

}
