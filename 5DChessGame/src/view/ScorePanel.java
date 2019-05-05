package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.LoginActionListener;
import control.RegisterActionListener;
import model.GameEngine;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel {
    	private GameEngineGUI frame;
    	private GameEngine model;

	 	private JButton login = new JButton("login");
	    private JButton register = new JButton("register");
	    private CustomJLabel[] playerScore = new CustomJLabel[2];
	    private CustomJLabel[] playerColor= new CustomJLabel[2];

	    private CustomJLabel[] playerNumOfMove = new CustomJLabel[2];
	    private CustomJLabel currentTurn = new CustomJLabel();
	    private CustomJLabel winner = new CustomJLabel();

	public ScorePanel(GameEngineGUI frame, GameEngine model) {
		this.frame = frame;
		this.model = model;
		
		login.setSize(new Dimension(200, 200));
		login.setFont(new Font("Serif", Font.PLAIN, 20));
		LoginActionListener loginActionListener = new LoginActionListener(this.frame, this.model);
	    login.addActionListener(loginActionListener);
		this.add(login);


		register.setPreferredSize(new Dimension(200, 200));
		register.setFont(new Font("Serif", Font.PLAIN, 20));
		RegisterActionListener registerActionListener = new RegisterActionListener(this.frame, this.model);
		register.addActionListener(registerActionListener);
		this.add(register);
		
		this.add(new CustomJLabel("Player 1:"));
		this.add(playerColor[0]= new CustomJLabel());
		this.add(new CustomJLabel("Num of moves:"));
		this.add(playerNumOfMove[0]= new CustomJLabel());
		this.add(new CustomJLabel("Score:"));
		this.add(playerScore[0]= new CustomJLabel());

		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
				
		this.add(new CustomJLabel("Current turn:"));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel("Remain moves:"));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel("WINNER:"));
		this.add(new CustomJLabel(""));

		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		this.add(new CustomJLabel(""));
		
		this.add(new CustomJLabel("Player 2:"));
		this.add(playerColor[1]= new CustomJLabel());
		this.add(new CustomJLabel("Num of moves:"));
		this.add(playerNumOfMove[1]= new CustomJLabel());
		this.add(new CustomJLabel("Score:"));
		this.add(playerScore[1]= new CustomJLabel());

		this.setBackground(new Color(255, 222, 173));   
		this.setLayout(new GridLayout(18,2, 2, 2));
		this.setPreferredSize(new Dimension(300, 0));
	}

}

@SuppressWarnings("serial")
class CustomJLabel extends JLabel {
	public CustomJLabel(String label) {
		super(label);
		this.setFont(new Font("Serif", Font.PLAIN, 20));
	}
	public CustomJLabel() {
		this.setFont(new Font("Serif", Font.PLAIN, 20));
	}
}
