package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameEngine;
import view.LoginErrorGUI;
import view.LoginRegisterForm;
import view.MaxMovesForm;

public class LoginActionListener implements ActionListener  {

	GameEngine model;
	
	TextField playerId;
	TextField playerPwd;
	LoginRegisterForm frame;
	
	public LoginActionListener(GameEngine model, TextField user, TextField passTextBox, LoginRegisterForm frame) {
		
		this.model = model;
		this.playerId = user;
		this.playerPwd = passTextBox;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//LoginForm loginForm = new LoginForm(frame, model);
//		   JOptionPane.showMessageDialog(frame, "Simple Information Message"); 
		
		if(model.addPlayer(playerId.getText(), playerPwd.getText()))
		{
			this.frame.dispose();
			new MaxMovesForm(playerId.getText(),model);
//			maxMovesForm.renderGUI(playerId.getText(),model);
			
		}
		else
		{
			new LoginErrorGUI(frame);
		}
	}

}
