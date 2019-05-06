package controller;

import java.awt.Dialog;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.GameEngine;
import view.LoginErrorGUI;

public class LoginAction implements ActionListener{

	private JFrame frame;
	private GameEngine gameEngine;
	TextField userTextBox;
	TextField passTextBox;
	
	public LoginAction(JFrame frame, GameEngine gameEngine, TextField userTextBox, TextField passTextBox)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
		this.userTextBox = userTextBox;
		this.passTextBox = passTextBox;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gameEngine.loginPlayer(userTextBox.getText(), passTextBox.getText()) == true)
		{
			frame.dispose();
		}
		else
		{
			new LoginErrorGUI(frame);
		}
		
	}

}
