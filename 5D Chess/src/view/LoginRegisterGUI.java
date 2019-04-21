package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LoginRegisterGUI {
	
	Label player;
	Label user = new Label("Username");
	Label pass = new Label("Password");
	
	TextField userTextBox = new TextField(10);
	TextField passTextBox = new TextField(10);
	
	Button registerButton = new Button("Register");
	Button loginButton = new Button("Login");
	
	public LoginRegisterGUI(String player)
	{
		this.player = new Label(player, SwingConstants.CENTER);
	}
	
	public void renderGUI()
	{
		JFrame frame = new JFrame();
		
		JPanel topPanel = new JPanel();
		topPanel.add(player);
		topPanel.setLayout(new FlowLayout());
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(2,2,5,20));
		middlePanel.add(user);
		middlePanel.add(userTextBox);
		middlePanel.add(pass);
		middlePanel.add(passTextBox);
		
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(middlePanel, BorderLayout.CENTER);
		
		//frame.add(registerButton);
		//frame.add(loginButton);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
