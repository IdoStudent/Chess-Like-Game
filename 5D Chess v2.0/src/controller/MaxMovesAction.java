package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameEngine;

public class MaxMovesAction implements ActionListener{

	JFrame frame;
	Panel panel;
	GameEngine gameEngine;
	TextField maxMoves;
	
	public MaxMovesAction(JFrame frame, Panel panel, GameEngine gameEngine, TextField maxMoves) 
	{
		this.frame = frame;
		this.panel = panel;
		this.gameEngine = gameEngine;
		this.maxMoves = maxMoves;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int max = 0;
		try
		{
			max = Integer.parseInt(maxMoves.getText());
			if(max >= 10 && max <= 90)
			{
				if(gameEngine.getPlayers()[0].getMaxMoves() == 0)
				{
					gameEngine.getPlayers()[0].setMaxMoves(max);
				}
				else
				{
					gameEngine.getPlayers()[1].setMaxMoves(max);
				}
				frame.dispose();
			}
			else
			{
				renderError();
			}
		} catch(Exception x) {renderError();}
	}
	
	private void renderError()
	{
		frame.setSize(300,150);
		Label error = new Label("ERROR: Enter number between 10 and 90!");
		error.setForeground(Color.RED);
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new FlowLayout());
		errorPanel.add(error);
		panel.add(errorPanel);
	}

}
