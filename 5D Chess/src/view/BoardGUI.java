package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import conroller.LoginAction;
import conroller.SquareAction;
import model.GameEngine;
import model.Piece;
import model.Player;

public class BoardGUI {
	
	private JFrame frame;
	JPanel board;
	
	Panel console;
	Panel playerInfo;
	
	Panel player1;
	Panel player2;
	
	JTextArea text = new JTextArea(7, 70);
	
	JButton[][] chessBoardSquares;
	
	public BoardGUI(GameEngine gameEngine)
	{
		frame = new JFrame("5D Chess");
		frame.setLayout(new BorderLayout());
		frame.getContentPane();
		frame.setBackground(Color.LIGHT_GRAY);
		
		frame.add(boardPanel(), BorderLayout.CENTER);
		//Adds action listeners to each square button in the board chessBoardSquares[][]
		addActionListener(gameEngine);
		
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
	
	public void endGame(Player winner, GameEngine gameEngine)
	{
		
		Panel centerText = new Panel();
		centerText.setLayout(new FlowLayout());		
		centerText.add(new JLabel("Winner: " + winner.getPlayerId() + "! Thank you for playing."));
		
		Panel centerButton = new Panel();
		centerButton.setLayout(new FlowLayout());
		JButton endGameButton = new JButton("exit");
		endGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameEngine.writeDataToFile(winner);
			}
		});
		centerButton.add(endGameButton);
		
		Panel winnerPanel = new Panel();
		winnerPanel.setLayout(new BoxLayout(winnerPanel, BoxLayout.Y_AXIS));
		winnerPanel.add(centerText);
		winnerPanel.add(centerButton);
		
		JDialog dialog = new JDialog(frame, "", Dialog.ModalityType.DOCUMENT_MODAL);
		
		dialog.add(winnerPanel);
		
		dialog.setSize(230,100);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		player1.removeAll();
		player2.removeAll();
		
		player1.add(playerPanel("Player 1", gameEngine), BorderLayout.NORTH);
		player1.add(new JLabel("Current Turn: " + currentTurn(gameEngine)), BorderLayout.SOUTH);
		
		player2.add(playerPanel("Player 2", gameEngine), BorderLayout.SOUTH);
		player2.add(new JLabel("Moves Left: " + gameEngine.getMaxMoves()), BorderLayout.NORTH);
		
		playerInfo.add(player1);
		playerInfo.add(player2);
		
		playerInfo.revalidate();
		frame.add(playerInfo, BorderLayout.WEST);
		playerInfo.setPreferredSize(new Dimension(150, 150));
	}
	
	private JPanel boardPanel()
	{
		board = new JPanel(new GridLayout(0,6));
		board.setBorder(new LineBorder(Color.BLACK));
		
		chessBoardSquares = new JButton[6][6];
		
	    // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < chessBoardSquares.length; i++) 
        {
            for (int j = 0; j < chessBoardSquares[i].length; j++)
            {	
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1)
                        //) {
                        || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.DARK_GRAY);
                } else {
                    b.setBackground(Color.LIGHT_GRAY);
                }
                chessBoardSquares[j][i] = b;
            }
        }
        
        // fill the black non-pawn piece row
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) 
            {
            	board.add(chessBoardSquares[j][i]);
            }
        }

		return board;
	}
	
	private void addActionListener(GameEngine gameEngine)
	{
		for(int x = 0; x < 6; x++)
		{
			for(int y = 0; y < 6; y++)
			{
				int xPos = x;
				int yPos = y;
				chessBoardSquares[x][y].addActionListener(new SquareAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						gameEngine.buttonPressed(xPos, yPos);
					}
				});
			}
		}
	}
	
	private Panel playerPanel(String player, GameEngine gameEngine)
	{
		int index;
		String type;
		
		Panel PlayerInfo = new Panel();
		
		if(player.equals("Player 1"))
		{
			index = 0;
			type = "(white)";
		}
		else
		{
			index = 1;
			PlayerInfo.setLayout(new BorderLayout());
			type = "(black)";
		}
		
		PlayerInfo = new Panel();
		PlayerInfo.setLayout(new BoxLayout(PlayerInfo, BoxLayout.PAGE_AXIS));
		JLabel pH = new JLabel(player + " info " + type + ":");
		PlayerInfo.add(pH);
		JLabel pPoints = new JLabel("Points: " + gameEngine.getPlayers()[index].getScore());
		JLabel pUsername = new JLabel("Username: " + gameEngine.getPlayers()[index].getPlayerId());
		JLabel pMoves = new JLabel("Moves: " + gameEngine.getPlayers()[index].getNumOfMove());
		PlayerInfo.add(pUsername);
		PlayerInfo.add(pPoints);
		PlayerInfo.add(pMoves);
		
		return PlayerInfo;
	}
	
	private String currentTurn(GameEngine gameEngine)
	{
		String currentTurn = gameEngine.getPlayers()[0].getPlayerId();
		if(gameEngine.getPlayerTurn() == false)
		{
			currentTurn = gameEngine.getPlayers()[1].getPlayerId();
		}	
		return currentTurn;
	}
	
	public void renderPieces(GameEngine gameEngine)
	{
		for(Piece p : gameEngine.getPieces())
		{
			int y = p.getY();
			int x = p.getX();
			
			if(p.getEliminated() == false)
			{
	            ImageIcon icon = new ImageIcon(p.getImage());
	            
				chessBoardSquares[x][y].setIcon(icon);
			}
		}
	}
	
	public void renderSelectedPiece(int x, int y)
	{
		unRenderBoardColor();
		chessBoardSquares[x][y].setBackground(Color.blue);
	}
	
	public void renderPossibleMoves(int newX, int newY, GameEngine gameEngine)
	{
		chessBoardSquares[newX][newY].setBackground(Color.GREEN);
		for(Piece p : gameEngine.getPieces())
		{
			if(p.getX() == newX &&
			   p.getY() == newY)
			{
				chessBoardSquares[newX][newY].setBackground(Color.RED);
			}
		}
	}
	
	public void unRenderBoardColor()
	{
		for(int x = 0; x < 6; x++)
		{
			for(int y = 0; y < 6; y++)
			{
                if ((y % 2 == 1 && x % 2 == 1)
                        //) {
                        || (y % 2 == 0 && x % 2 == 0)) {
                	chessBoardSquares[x][y].setBackground(Color.DARK_GRAY);
                } else {
                	chessBoardSquares[x][y].setBackground(Color.LIGHT_GRAY);
                }
			}
		}
	}
	
	public void unRenderPosition(int x, int y)
	{
        ImageIcon icon = new ImageIcon(
                new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        chessBoardSquares[x][y].setIcon(icon);
	}
}
