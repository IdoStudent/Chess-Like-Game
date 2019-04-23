package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import model.GameEngine;
import model.Piece;

public class BoardGUI {
	
	private JFrame frame;
	JPanel board;
	
	Panel console;
	JTextArea text = new JTextArea(7, 70);
	
	JButton[][] chessBoardSquares;
	
	public BoardGUI()
	{
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.getContentPane();
		frame.setBackground(Color.LIGHT_GRAY);
		
		frame.add(boardPanel(), BorderLayout.CENTER);
		
		//player info west panel which includes each players info
		Panel playerInfo = new Panel();
		playerInfo.setLayout(new GridLayout(2,1));
		
		Panel player1 = new Panel();
		player1.setLayout(new BorderLayout());
		player1.add(playerPanel("Player 1", gameEngine), BorderLayout.NORTH);
		
		Panel player2 = new Panel();
		player2.setLayout(new BorderLayout());
		player2.add(playerPanel("Player 2", gameEngine), BorderLayout.SOUTH);
		
		playerInfo.add(player1);
		playerInfo.add(player2);
		frame.add(playerInfo, BorderLayout.WEST);
		
		//South panel which includes the console
		console = new Panel();
		console.setLayout(new BoxLayout(console, BoxLayout.PAGE_AXIS));
		Console cons = new Console(text, 10);
		System.setOut(new PrintStream(cons));
		console.add(new JScrollPane(text));
		frame.add(console, BorderLayout.SOUTH);
		
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
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
	
	private Panel playerPanel(String player, GameEngine gameEngine)
	{
		int index;
		
		Panel PlayerInfo = new Panel();
		
		if(player.equals("Player 1"))
		{
			index = 0;
		}
		else
		{
			index = 1;
			PlayerInfo.setLayout(new BorderLayout());
		}
		
		PlayerInfo = new Panel();
		PlayerInfo.setLayout(new BoxLayout(PlayerInfo, BoxLayout.PAGE_AXIS));
		JLabel pH = new JLabel(player + " info:");
		PlayerInfo.add(pH);
		JLabel pPoints = new JLabel("Points: " + gameEngine.getPlayers()[index].getScore());
		JLabel pUsername = new JLabel("Username: " + gameEngine.getPlayers()[index].getPlayerId());
		JLabel pMoves = new JLabel("Moves: " + gameEngine.getPlayers()[index].getNumOfMove());
		PlayerInfo.add(pUsername);
		PlayerInfo.add(pPoints);
		PlayerInfo.add(pMoves);
		
		return PlayerInfo;
	}
	
	public void renderPieces(GameEngine gameEngine)
	{
		for(Piece p : gameEngine.getPieces())
		{
			int y = p.getY();
			int x = p.getX();
			
            ImageIcon icon = new ImageIcon(p.getImage());
            
			chessBoardSquares[x][y].setIcon(icon);
		}
	}
}
