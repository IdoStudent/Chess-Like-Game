package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameEngine;

public class ScorePanel extends JPanel {
	
	public ScorePanel(String player, GameEngine gameEngine)
	{
		playerPanel(player, gameEngine);
	}

	private void playerPanel(String player, GameEngine gameEngine)
	{
		int index;
		String type;
		
		if(player.equals("Player 1"))
		{
			index = 0;
			type = "(white)";
		}
		else
		{
			index = 1;
			setLayout(new BorderLayout());
			type = "(black)";
		}
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JLabel pH = new JLabel(player + " info " + type + ":");
		add(pH);
		JLabel pUsername = new JLabel("Username: " + gameEngine.getAllPlayers()[index].getUserId());
		JLabel winLossratio = new JLabel("Win/Loss ratio: " + gameEngine.getAllPlayers()[index].getWins() + "-" + gameEngine.getAllPlayers()[index].getLosses());
		JLabel pPoints = new JLabel("Points: " + gameEngine.getAllPlayers()[index].getScore());
		JLabel pMoves = new JLabel("Moves: " + gameEngine.getAllPlayers()[index].getNumOfMove());
		add(pUsername);
		add(winLossratio);
		add(pPoints);
		add(pMoves);
		
	}
	
	public void updateScoreInfo() {
		// TODO Auto-generated method stub
		
	}

}
