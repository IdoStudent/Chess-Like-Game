package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.GameEngine;
import view.RegisterErrorGUI;

public class RegisterActionListener implements ActionListener {
	
	GameEngine model;
	
	TextField user;
	TextField pass;
	JFrame frame;


	public RegisterActionListener(GameEngine model, TextField user, TextField pass, JFrame frame) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.user = user;
		this.pass = pass;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(model.register(user.getText(), pass.getText()) == true)
		{
			frame.dispose();
		}
		else
		{
			new RegisterErrorGUI(frame);
		}

	}

}
