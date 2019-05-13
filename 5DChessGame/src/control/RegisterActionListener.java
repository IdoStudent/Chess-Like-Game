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
	
	GameEngine gameEngine;
	TextField user;
	TextField pass;
	JFrame frame;

	public RegisterActionListener(GameEngine gameEngine, TextField user, TextField passTextBox, JFrame frame) {
		this.gameEngine = gameEngine;
		this.user = user;
		pass = passTextBox;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if(gameEngine.addUser(user.getText(), pass.getText())){
			frame.dispose();
			JOptionPane.showMessageDialog(frame, "You have successfully registered an account");
			if (gameEngine.getNumOfPlayers()<2) {
				new LoginRegisterForm(gameEngine);
			}
		}else{
			new RegisterErrorGUI(frame);
		}
	}
}
