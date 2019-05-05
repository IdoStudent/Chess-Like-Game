package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameEngine;
import view.GameEngineGUI;
import view.LoginForm;
import view.RegisterForm;

public class RegisterActionListener implements ActionListener {
	private GameEngineGUI frame;
	private GameEngine model;
	private LoginForm loginFrame;


	public RegisterActionListener(GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.model = model;
	}
	
	public RegisterActionListener(LoginForm loginFrame, GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		this.loginFrame = loginFrame;
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if (loginFrame!=null) loginFrame.setVisible(false);	
			RegisterForm registerForm = new RegisterForm(frame, model);
		

	}

}
