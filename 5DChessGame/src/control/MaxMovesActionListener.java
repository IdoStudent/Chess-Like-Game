package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.GameEngine;
import view.GameEngineGUI;
import view.LoginRegisterForm;
import view.MaxMovesForm;

public class MaxMovesActionListener implements ActionListener {

	String playerID;
	TextField maxMovesText;
	MaxMovesForm maxMovesForm;
	GameEngine gameEngine;
	
	public MaxMovesActionListener(String playerID, GameEngine gameEngine, TextField maxMovesText, MaxMovesForm maxMovesForm)
	{
		this.playerID = playerID;
		this.maxMovesText = maxMovesText;
		this.gameEngine = gameEngine;
		this.maxMovesForm = maxMovesForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int max = 0;
		try
		{
			max = Integer.parseInt(maxMovesText.getText());
			if(max >= 10 && max <= 90)
			{
				gameEngine.assignNumofMove(playerID, Integer.parseInt(maxMovesText.getText()));
				
				if (this.gameEngine.getNumOfPlayers()==1) {
					new LoginRegisterForm(gameEngine);
				}
				
				if (gameEngine.getNumOfPlayers()==2) {
					gameEngine.StartGame();
					GameEngineGUI gameGUI = new GameEngineGUI(gameEngine);
					gameGUI.updateGameGUI();
				}
				maxMovesForm.dispose();
			}
			else
			{
				maxMovesForm.renderError();
			}
		} catch(Exception x) {maxMovesForm.renderError();}
	}

}
