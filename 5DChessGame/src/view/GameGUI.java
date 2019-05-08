package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.GameEngine;

public class GameGUI {
	
	JFrame frame;
	JPanel board;
	
	Panel console;
	Panel playerInfo;
	
	Panel player1;
	Panel player2;
	
	JTextArea text = new JTextArea(7, 70);
	
	JButton[][] chessBoardSquares;
	
	public GameGUI(GameEngineGUI gameEngineGUI, GameEngine gameEngine)
	{
		frame = new JFrame("5D Chess");
		frame.setLayout(new BorderLayout());
		frame.getContentPane();
		frame.setBackground(Color.LIGHT_GRAY);
		
		frame.add(new ChessBoard(gameEngineGUI, gameEngine), BorderLayout.CENTER);

		//player info west panel which includes each players info
		playerInfo = new Panel();
		playerInfo.setLayout(new GridLayout(2,1));
		
		player1 = new Panel();
		player1.setLayout(new BorderLayout());
		player2 = new Panel();
		player2.setLayout(new BorderLayout());
		
		//South panel which includes the console
		console = new Panel();
		console.setLayout(new BoxLayout(console, BoxLayout.PAGE_AXIS));
		Console cons = new Console(text, 10);
		System.setOut(new PrintStream(cons));
		console.add(new JScrollPane(text));
		frame.add(console, BorderLayout.SOUTH);
		
		
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		player1.removeAll();
		player2.removeAll();
		
		ScorePanel p1 = new ScorePanel("Player 1", gameEngine);
		ScorePanel p2 = new ScorePanel("Player 2", gameEngine);
		
		player1.add(p1, BorderLayout.NORTH);
		player1.add(new JLabel("Current Turn: " + currentTurn(gameEngine)), BorderLayout.SOUTH);
		
		player2.add(p2, BorderLayout.SOUTH);
		player2.add(new JLabel("Moves Left: " + gameEngine.getMaxMove()), BorderLayout.NORTH);
		
		playerInfo.add(player1);
		playerInfo.add(player2);
		
		playerInfo.revalidate();
		frame.add(playerInfo, BorderLayout.WEST);
		playerInfo.setPreferredSize(new Dimension(150, 150));
	}
	
	private String currentTurn(GameEngine gameEngine)
	{
		String currentTurn;
		
		if(gameEngine.getCurrentTurn() == 1)
		{
			currentTurn = gameEngine.getAllPlayers()[0].getUserId();
		}
		else
		{
			currentTurn = gameEngine.getAllPlayers()[1].getUserId();
		}
		return currentTurn;
	}

}
