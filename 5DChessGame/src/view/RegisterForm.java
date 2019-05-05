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
import model.GameEngine;

public class RegisterForm extends JFrame implements ActionListener
{
	 private JLabel l1, labelID, labelPwd;
	 private JTextField memberID;
	 private JButton register;
	 private JPasswordField memberPwd;

    private GameEngineGUI frame;
	private GameEngine model;

	public RegisterForm(GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		super("Register Form");
		this.frame = frame;
		this.model = model;

		labelID = new CustomJLabel("Member ID:");
		memberID = new JTextField();
		labelPwd = new CustomJLabel("Member Password:");
		memberPwd = new JPasswordField();
		register = new JButton("Register");
		register.setFont(new Font("Serif", Font.PLAIN, 20));
//		login.setSize(70, 30);
		register.setSize(new Dimension(200, 200));

		labelID.setBounds(80, 70, 200, 30);
		labelPwd.setBounds(80, 110, 200, 30);
		memberID.setBounds(300, 70, 200, 30);
		memberPwd.setBounds(300, 110, 200, 30);
		register.setBounds(300, 160, 100, 30);
		register.addActionListener(this);

		this.add(labelID);
		this.add(labelPwd);
		this.add(memberID);
		this.add(memberPwd);
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
		 String uname = memberID.getText();
		 String pass = memberPwd.getText();
		 
			   if (this.model.addUser(uname, pass)) {
					JOptionPane.showMessageDialog(this, "You have successfully registered an account");
			        this.setVisible(false);	

				} else {
					JOptionPane.showMessageDialog(this, "Account already exists! Try to create a new one", "Error", JOptionPane.ERROR_MESSAGE);
				}	  	 
	
	}

}
