package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngine;
import view.GameEngineGUI;
import view.LoginForm;

public class LoginActionListener implements ActionListener  {

	private  GameEngine model;
	
	TextField user;
	TextField pass;

	public LoginActionListener(GameEngine model, TextField user, TextField pass) {
		
		this.model = model;
		this.user = user;
		this.pass = pass;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//LoginForm loginForm = new LoginForm(frame, model);
//		   JOptionPane.showMessageDialog(frame, "Simple Information Message"); 
	}

}
