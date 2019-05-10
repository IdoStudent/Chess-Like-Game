package controller;

import java.awt.Dialog;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.GameEngine;
import view.RegisterErrorGUI;

public class RegisterAction implements ActionListener{

	private JFrame frame;
	private GameEngine gameEngine;
	TextField userTextBox;
	TextField passTextBox;
	
	public RegisterAction(JFrame frame, GameEngine gameEngine, TextField userTextBox, TextField passTextBox) 
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
		this.userTextBox = userTextBox;
		this.passTextBox = passTextBox;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(gameEngine.registerPlayer(userTextBox.getText(), passTextBox.getText()) == true)
		{
			frame.dispose();
		}
		else
		{
			new RegisterErrorGUI(frame);
		}
	}

}
