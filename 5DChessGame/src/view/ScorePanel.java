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
import model.Player;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel {
    	private GameEngineGUI frame;
    	private GameEngine model;
	 	private JButton login = new JButton("login");
	    private JButton register = new JButton("register");
	    private CustomJLabel[] playerinfo;
//	    private CustomJLabel player2info;
	    private CustomJLabel[] playerNumOfMove;
	    private CustomJLabel[] playerScore;

	    private CustomJLabel currentTurn;
	    private CustomJLabel remainMove;
	    private CustomJLabel gameResult;



	    

	public ScorePanel(GameEngineGUI frame, GameEngine model) {
		this.frame = frame;
		this.model = model;
		
		this.renderLoginRegisterGUI(model);
		if (this.model.getNumOfPlayers()==2) {
			this.renderScoreInfo(model);
		}
		this.setBackground(new Color(255, 222, 173));   
		this.setLayout(new GridLayout(19,1));
		this.setPreferredSize(new Dimension(300, 0));
	}

	public void renderLoginRegisterGUI(GameEngine model) {
		// Login button
		login.setSize(new Dimension(200, 200));
		login.setFont(new Font("Serif", Font.PLAIN, 20));
		LoginActionListener loginActionListener = new LoginActionListener(this.frame, this.model);
	    login.addActionListener(loginActionListener);
		this.add(login);

		// Register button
		register.setPreferredSize(new Dimension(200, 200));
		register.setFont(new Font("Serif", Font.PLAIN, 20));
		RegisterActionListener registerActionListener = new RegisterActionListener(this.frame, this.model);
		register.addActionListener(registerActionListener);
		this.add(register);
		if (this.model.getNumOfPlayers()==2) {
		}
	}
	
	public void renderScoreInfo(GameEngine model) {
	
		//Score bar information
			Player player1 = this.model.getAllPlayers()[0];
			Player player2 = this.model.getAllPlayers()[1];
			playerNumOfMove[0]=new CustomJLabel("Player 1:" + player1.getUserId());
			this.add(playerNumOfMove[0]);
			this.add(new CustomJLabel("Num of moves: " + player1.getNumOfMove() ));
			this.add(new CustomJLabel("Score: " + player1.getScore() ));

			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			
					
			this.add(new CustomJLabel("Current turn:" + this.model.getTurn()));
			this.add(new CustomJLabel("Remain moves: " + (this.model.getMaxMove() - this.model.getNumOfMoves())));
			this.add(new CustomJLabel(this.model.getGameResult()));

			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			
			this.add(new CustomJLabel("Player 2: "+  player2.getUserId()));
			this.add(new CustomJLabel("Num of moves:" + player2.getNumOfMove()));
			this.add(new CustomJLabel("Score: " + player2.getScore() ));
		
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
