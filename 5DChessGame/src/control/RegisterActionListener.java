package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameEngine;
import view.GameEngineGUI;
import view.LoginForm;
import view.RegisterForm;

public class RegisterActionListener implements ActionListener {
	
	private GameEngine model;
	
	TextField user;
	TextField pass;


	public RegisterActionListener(GameEngine model, TextField user, TextField pass) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//			if (loginFrame!=null) loginFrame.setVisible(false);	
//			RegisterForm registerForm = new RegisterForm(frame, model);
		

	}

}
