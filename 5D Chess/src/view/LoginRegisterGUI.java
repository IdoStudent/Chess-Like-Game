package view;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginRegisterGUI {
	
	Label player;
	Label user = new Label("Username: ");
	Label pass = new Label("Password: ");
	
	TextField userTextBox = new TextField(15);
	TextField passTextBox = new TextField(15);
	
	Button registerButton = new Button("Register");
	Button loginButton = new Button("Login");
	
	public LoginRegisterGUI(String player)
	{
		this.player = new Label(player + " login:");
	}
	
	public void renderGUI()
	{
		passTextBox.setEchoChar('*');
		
		JFrame frame = new JFrame();
		Panel panel = new Panel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.add(panel);
		
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(player);
		panel.add(topPanel);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(new FlowLayout());
		usernamePanel.add(user);
		usernamePanel.add(userTextBox);
		panel.add(usernamePanel);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new FlowLayout());
		passwordPanel.add(pass);
		passwordPanel.add(passTextBox);
		panel.add(passwordPanel);
		
		JPanel loginRegisterPanel = new JPanel();
		loginRegisterPanel.add(registerButton);
		loginRegisterPanel.add(loginButton);
		panel.add(loginRegisterPanel);
		
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
