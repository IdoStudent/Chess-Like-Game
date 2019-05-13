package control;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameEngine;
import view.LoginErrorGUI;
import view.LoginRegisterForm;
import view.MaxMovesForm;

public class LoginActionListener implements ActionListener  {

	private GameEngine gameEngine;
	private TextField playerId;
	private TextField playerPwd;
	private LoginRegisterForm frame;
	
	public LoginActionListener(GameEngine gameEngine, TextField user, TextField passTextBox, LoginRegisterForm frame) {
		
		this.gameEngine = gameEngine;
		playerId = user;
		playerPwd = passTextBox;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gameEngine.addPlayer(playerId.getText(), playerPwd.getText())){
			frame.dispose();
			new MaxMovesForm(playerId.getText(),gameEngine);		
		}else{
			new LoginErrorGUI(frame);
		}
	}
}
