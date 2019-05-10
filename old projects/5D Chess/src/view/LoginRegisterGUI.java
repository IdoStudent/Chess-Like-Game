package view;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conroller.LoginAction;
import conroller.RegisterAction;
import model.GameEngine;

public class LoginRegisterGUI {
	
	JFrame frame;
	Label player;
	Label user = new Label("Username: ");
	Label pass = new Label("Password: ");
	
	TextField userTextBox = new TextField(15);
	TextField passTextBox = new TextField(15);
	
	JButton registerButton = new JButton("Register");
	JButton loginButton = new JButton("Login");
	
	JDialog dialog;
	
	public LoginRegisterGUI(String player)
	{
		this.player = new Label(player + " enter details:");
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		loginButton.addActionListener(new LoginAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameEngine.loginPlayer(userTextBox.getText(), passTextBox.getText()) == true)
				{
					frame.dispose();
				}
				else
				{
					renderDialog(loginError());
				}
			}
		});
		registerButton.addActionListener(new RegisterAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameEngine.registerPlayer(userTextBox.getText(), passTextBox.getText()) == true)
				{
					frame.dispose();
				}
				else
				{
					renderDialog(registerError());
				}
			}
		});
		
		passTextBox.setEchoChar('*');
		
		frame = new JFrame();
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
	
	private Panel loginError()
	{
		Panel centerText = new Panel();
		centerText.setLayout(new FlowLayout());		
		centerText.add(new JLabel("ERROR due to one of the following:"));
		
		Panel errorType1 = new Panel();
		errorType1.setLayout(new FlowLayout());		
		errorType1.add(new JLabel("1. Username does not exist in system."));
		
		Panel errorType2 = new Panel();
		errorType2.setLayout(new FlowLayout());		
		errorType2.add(new JLabel("2. Password is incorrect."));
		
		Panel errorType3 = new Panel();
		errorType3.setLayout(new FlowLayout());		
		errorType3.add(new JLabel("3. Username or password includes illegal character \':\' "));
		
		Panel centerButton = new Panel();
		centerButton.setLayout(new FlowLayout());
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		centerButton.add(okButton);
		
		Panel errorPanel = new Panel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.PAGE_AXIS));
		errorPanel.add(centerText);
		errorPanel.add(errorType1);
		errorPanel.add(errorType2);
		errorPanel.add(errorType3);
		errorPanel.add(centerButton);
		
		return errorPanel;
	}
	
	private Panel registerError()
	{
		
		Panel centerText = new Panel();
		centerText.setLayout(new FlowLayout());		
		centerText.add(new JLabel("ERROR due to one of the following:"));
		
		Panel errorType1 = new Panel();
		errorType1.setLayout(new FlowLayout());		
		errorType1.add(new JLabel("1. Username already exists in the system."));
		
		Panel errorType2 = new Panel();
		errorType2.setLayout(new FlowLayout());		
		errorType2.add(new JLabel("2. Username or password includes illegal character \':\' "));
		
		Panel errorType3 = new Panel();
		errorType3.setLayout(new FlowLayout());		
		errorType3.add(new JLabel("3. Username must be 10 characters or less."));
		
		Panel centerButton = new Panel();
		centerButton.setLayout(new FlowLayout());
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		centerButton.add(okButton);
		
		Panel errorPanel = new Panel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.PAGE_AXIS));
		errorPanel.add(centerText);
		errorPanel.add(errorType1);
		errorPanel.add(errorType2);
		errorPanel.add(errorType3);
		errorPanel.add(centerButton);
		
		return errorPanel;
	}
	
	private void renderDialog(Panel errorPanel)
	{
		dialog = new JDialog(frame, "", Dialog.ModalityType.DOCUMENT_MODAL);
		
		dialog.add(errorPanel);
		
		dialog.setSize(350,250);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	
	
}
