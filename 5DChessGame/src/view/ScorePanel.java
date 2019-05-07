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
	    private CustomJLabel[] playerinfo = new CustomJLabel[2];
	    private CustomJLabel[] playerId  = new CustomJLabel[2];;
	    private CustomJLabel[] playerScore  = new CustomJLabel[2];;

	    private CustomJLabel currentTurn;
	    private CustomJLabel remainMove;
	    private CustomJLabel gameResult;
	    

	public ScorePanel(GameEngineGUI frame, GameEngine model) {
		this.frame = frame;
		this.model = model;
		
		this.renderLoginRegisterGUI(model);
//		if (this.model.getNumOfPlayers()==2) {
			this.renderScoreInfo();
//		}
//		this.renderScoreInfo(model);
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
//		if (this.model.getNumOfPlayers()==2) {
//		}
	}
	
	public void renderScoreInfo() {
	
		//Score bar information
//			Player player1 = this.model.getAllPlayers()[0];
//			Player player2 = this.model.getAllPlayers()[1];
			
			playerinfo[0]=new CustomJLabel("");
			playerId[0] = new CustomJLabel(""); 
			playerScore[0] = new CustomJLabel(""); 
			this.add(playerinfo[0]);
			this.add(playerId[0]);
			this.add(playerScore[0]);


			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			
			currentTurn = new CustomJLabel("");		
			remainMove = new CustomJLabel("");
			gameResult = new CustomJLabel("");
			this.add(remainMove);
			this.add(currentTurn);
			this.add(gameResult);

			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			this.add(new CustomJLabel(""));
			
			playerinfo[1]=new CustomJLabel("");
			playerId[1] = new CustomJLabel(""); 
			playerScore[1] = new CustomJLabel(""); 
			this.add(playerinfo[1]);
			this.add(playerScore[1]);
			this.add(playerId[1]);
		
	}
	
	public void updateScoreInfo() {
		Player player1 = this.model.getAllPlayers()[0];
		Player player2 = this.model.getAllPlayers()[1];
//		this.playerNumOfMove[0].setText("Num of moves: " + player1.getNumOfMove());

		this.playerinfo[0].setText("Player 1: BLACK");
		this.playerId[0].setText("Num of moves: " + player1.getNumOfMove());
		this.playerScore[0].setText("Score: " + player1.getScore());
		
		this.currentTurn.setText("Current turn:" + this.model.getCurrentTurn());
		this.remainMove.setText("Remain moves: " + (this.model.getMaxMove() - this.model.getNumOfMoves()));
		this.gameResult.setText(this.model.getGameResult().toString());
		
		this.playerinfo[1].setText("Player 2: WHITE");
		this.playerId[1].setText("Num of moves: " + player2.getNumOfMove());
		this.playerScore[1].setText("Score: " + player2.getScore());
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
