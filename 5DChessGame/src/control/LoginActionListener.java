package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.GameEngine;
import view.LoginErrorGUI;

public class LoginActionListener implements ActionListener  {

	GameEngine model;
	
	TextField user;
	TextField pass;
	JFrame frame;
	
	public LoginActionListener(GameEngine model, TextField user, TextField pass, JFrame frame) {
		
		this.model = model;
		this.user = user;
		this.pass = pass;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//LoginForm loginForm = new LoginForm(frame, model);
//		   JOptionPane.showMessageDialog(frame, "Simple Information Message"); 
		
		if(model.login(user.getText(), pass.getText()) == true)
		{
			frame.dispose();
		}
		else
		{
			new LoginErrorGUI(frame);
		}
	}

}
