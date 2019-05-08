package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.GameEngine;
import view.MaxMovesForm;

public class MaxMovesActionListener implements ActionListener {

	GameEngine gameEngine;
	TextField maxMovesText;
	MaxMovesForm maxMovesForm;
	JFrame frame;
	
	public MaxMovesActionListener(GameEngine gameEngine, TextField maxMovesText, MaxMovesForm maxMovesForm, JFrame frame)
	{
		this.gameEngine = gameEngine;
		this.maxMovesText = maxMovesText;
		this.maxMovesForm = maxMovesForm;
		this.frame = frame;
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
				gameEngine.addMaxMoves(max);
				frame.dispose();
			}
			else
			{
				maxMovesForm.renderError();
			}
		} catch(Exception x) {maxMovesForm.renderError();}
	}

}
