package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngine;
import view.MaxMovesForm;

public class MaxMovesActionListener implements ActionListener {

	GameEngine gameEngine;
	TextField maxMoves;
	MaxMovesForm maxMovesForm;
	
	public MaxMovesActionListener(GameEngine gameEngine, TextField maxMoves, MaxMovesForm maxMovesForm)
	{
		this.gameEngine = gameEngine;
		this.maxMoves = maxMoves;
		this.maxMovesForm = maxMovesForm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
