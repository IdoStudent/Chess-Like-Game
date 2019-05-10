package view;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.LoginActionListener;
import control.RegisterActionListener;
import model.GameEngine;

public class LoginRegisterForm extends JFrame{
	
	Label playerLabel;
	Label user = new Label("Username: ");
	Label pass = new Label("Password: ");
	
	private TextField userTextBox = new TextField(15);
	private TextField passTextBox = new TextField(15);
	private JButton registerButton = new JButton("Register");
	private JButton loginButton = new JButton("Login");
	private GameEngine gameEngine;
	
	public LoginRegisterForm(GameEngine gameEngine)
	{
		super("5D Chess");
		this.gameEngine = gameEngine;
		int playerNo = gameEngine.getNumOfPlayers()+1;
		this.playerLabel = new Label("Player " + playerNo + " enter details:");
		this.renderGUI(gameEngine);
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		passTextBox.setEchoChar('*');

		Panel panel = new Panel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.add(panel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(playerLabel);
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
		loginButton.addActionListener(new LoginActionListener(gameEngine, userTextBox, passTextBox, this));
		registerButton.addActionListener(new RegisterActionListener(gameEngine, userTextBox, passTextBox, this));
		panel.add(loginRegisterPanel);
		
		this.add(panel);
		
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}