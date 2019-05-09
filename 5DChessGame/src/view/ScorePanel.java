package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginActionListener;
import control.RegisterActionListener;
import model.GameEngine;
import model.Player;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel {
    	private GameEngineGUI gameEngineGUI;
    	private GameEngine gameEngine;
	    private CustomJLabel[] playerinfo = new CustomJLabel[2];
	    private CustomJLabel[] playerId  = new CustomJLabel[2];;
	    private CustomJLabel[] playerScore  = new CustomJLabel[2];;

	    private CustomJLabel currentTurn;
	    private CustomJLabel remainMove;
	    private CustomJLabel gameResult;
	    

	public ScorePanel(GameEngineGUI frame, GameEngine model) {
		this.gameEngineGUI = frame;
		this.gameEngine = model;
		this.renderScoreInfo();
		this.setLayout(new GridLayout(3,1));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setPreferredSize(new Dimension(250, 0));
	}

	
	public void renderScoreInfo() {
			
			Panel player1_panel = new Panel();
			player1_panel.setLayout(new GridLayout(6,1));
			playerinfo[0]=new CustomJLabel("");
			playerId[0] = new CustomJLabel(""); 
			playerScore[0] = new CustomJLabel(""); 
			player1_panel.add(playerinfo[0]);
			player1_panel.add(playerId[0]);
			player1_panel.add(playerScore[0]);
			this.add(player1_panel);

			
			Panel gameState_panel = new Panel();
			gameState_panel.setLayout(new GridLayout(6,1));
			currentTurn = new CustomJLabel("");		
			remainMove = new CustomJLabel("");
			gameResult = new CustomJLabel("");
			gameState_panel.add(remainMove);
			gameState_panel.add(currentTurn);
			gameState_panel.add(gameResult);			
			this.add(gameState_panel);

			
			Panel player2_panel = new Panel();
			player2_panel.setLayout(new GridLayout(6,1));
			player2_panel.add(new CustomJLabel(""));
			player2_panel.add(new CustomJLabel(""));
			player2_panel.add(new CustomJLabel(""));
			playerinfo[1]=new CustomJLabel("");
			playerId[1] = new CustomJLabel(""); 
			playerScore[1] = new CustomJLabel(""); 
			player2_panel.add(playerinfo[1]);
			player2_panel.add(playerId[1]);
			player2_panel.add(playerScore[1]);
			this.add(player2_panel);
		
	}
	
	public void updateScoreInfo() {
		Player player1 = this.gameEngine.getAllPlayers()[0];
		Player player2 = this.gameEngine.getAllPlayers()[1];

		this.playerinfo[0].setText("Player 1: BLACK");
		this.playerId[0].setText("Player ID: " + player1.getUserId());
		this.playerScore[0].setText("Score: " + player1.getScore());
		
		this.currentTurn.setText("Current turn:" + this.gameEngine.getCurrentTurn());
		this.remainMove.setText("Remain moves: " + (this.gameEngine.getMaxMove() - this.gameEngine.getNumOfMoves()));
		this.gameResult.setText(this.gameEngine.getGameResult().toString());
		
		this.playerinfo[1].setText("Player 2: WHITE");
		this.playerId[1].setText("Player ID: " + player2.getUserId());
		this.playerScore[1].setText("Score: " + player2.getScore());
	}
}



@SuppressWarnings("serial")
class CustomJLabel extends JLabel {
	public CustomJLabel(String label) {
		super(label);
		this.setFont(new Font("Serif", Font.BOLD, 16));
	}
	public CustomJLabel() {
		this.setFont(new Font("Serif", Font.BOLD, 16));
	}
}
