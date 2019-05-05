package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngine;
import view.GameEngineGUI;
import view.LoginForm;

public class LoginActionListener implements ActionListener  {
	private GameEngineGUI frame;
	private  GameEngine model;

	public LoginActionListener(GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.model = model;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		LoginForm loginForm = new LoginForm(frame, model);
//		   JOptionPane.showMessageDialog(frame, "Simple Information Message"); 
	}

}
