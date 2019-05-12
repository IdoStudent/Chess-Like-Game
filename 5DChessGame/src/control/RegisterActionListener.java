package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.GameEngine;
import view.LoginRegisterForm;
import view.RegisterErrorGUI;

public class RegisterActionListener implements ActionListener {
	
	GameEngine model;
	
	TextField user;
	TextField pass;
	JFrame frame;


	public RegisterActionListener(GameEngine model, TextField user, TextField passTextBox, JFrame frame) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.user = user;
		this.pass = passTextBox;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(model.addUser(user.getText(), pass.getText()) == true)
		{
			frame.dispose();
			JOptionPane.showMessageDialog(frame, "You have successfully registered an account");
			if (model.getNumOfPlayers()<2) {
				new LoginRegisterForm(model);
			}
		}
		else
		{
			new RegisterErrorGUI(frame);
		}

	}

}
