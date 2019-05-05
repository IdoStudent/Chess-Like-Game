package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.LoginActionListener;
import control.RegisterActionListener;
import model.GameEngine;

public class LoginForm extends JFrame implements ActionListener
{
	 private JLabel l1, labelID, labelPwd;
	 private JTextField memberID;
	 private JButton login;
	 private JButton register;

	 private JPasswordField memberPwd;

    private GameEngineGUI frame;
	private GameEngine model;

	public LoginForm(GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		super("Login Form");
		this.frame = frame;
		this.model = model;

		labelID = new CustomJLabel("Member ID:");
		memberID = new JTextField();
		labelPwd = new CustomJLabel("Member Password:");
		memberPwd = new JPasswordField();
		login = new JButton("Login");
		login.setFont(new Font("Serif", Font.PLAIN, 20));
		
		register = new JButton("Register");
		register.setFont(new Font("Serif", Font.PLAIN, 20));



		labelID.setBounds(80, 70, 200, 30);
		labelPwd.setBounds(80, 110, 200, 30);
		memberID.setBounds(300, 70, 200, 30);
		memberPwd.setBounds(300, 110, 200, 30);
		login.setBounds(190, 160, 100, 40);
		register.setBounds(310, 160, 100, 40);

	    login.addActionListener(this);

	    RegisterActionListener registerActionListener = new RegisterActionListener(this, this.frame, this.model);
		register.addActionListener(registerActionListener);
	    
		this.add(labelID);
		this.add(labelPwd);
		this.add(memberID);
		this.add(memberPwd);
		this.add(login);
		this.add(register);


		this.setLayout(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the frame
        this.setSize(600, 300);
        // Place the frame at the center of the screen.
        this.setLocationRelativeTo(null); 
        // make it visible
        this.setVisible(true);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String uid = memberID.getText();
		String pass = memberPwd.getText();

		if (model.addPlayer(uid, pass)) {
			JOptionPane.showMessageDialog(this, "Assign number of move");
			new NumOfMoveForm(uid,frame, model);
			this.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "Account doesn't exists! Register an account", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
