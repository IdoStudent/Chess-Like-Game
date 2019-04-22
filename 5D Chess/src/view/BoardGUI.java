package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.GameEngine;

public class BoardGUI {
	
	private JFrame frame;
	Panel board;
	
	Panel console;
	JTextArea text = new JTextArea(7, 70);
	
	Panel player1Info;
	Panel player2Info;
	
	public BoardGUI()
	{
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		player1Info = new Panel();
		player1Info.setLayout(new BoxLayout(player1Info, BoxLayout.PAGE_AXIS));
		JLabel p1H = new JLabel("Player 1 info:");
		p1H.setHorizontalAlignment(JLabel.CENTER);
		player1Info.add(p1H);
		JLabel p1points = new JLabel("Points: " + gameEngine.getPlayers()[0].getScore());
		p1points.setHorizontalAlignment(JLabel.CENTER);
		player1Info.add(p1points);
		
		player2Info = new Panel();
		player2Info.setLayout(new BoxLayout(player2Info, BoxLayout.PAGE_AXIS));
		JLabel p2H = new JLabel("Player 2 info:");
		p2H.setHorizontalAlignment(JLabel.CENTER);
		player2Info.add(p2H);
		JLabel p2points = new JLabel("Points: " + gameEngine.getPlayers()[0].getScore());
		p2points.setHorizontalAlignment(JLabel.CENTER);
		player2Info.add(p2points);
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.getContentPane();
		frame.setBackground(Color.LIGHT_GRAY);
		
		board = new Panel();
		frame.add(board, BorderLayout.CENTER);
		
		//player info south panel which includes each players info
		Panel playerInfo = new Panel();
		playerInfo.setLayout(new GridLayout(1,2));
		playerInfo.add(player1Info);
		playerInfo.add(player2Info);
		
		//South panel which includes the console and player info
		console = new Panel();
		console.setLayout(new BoxLayout(console, BoxLayout.PAGE_AXIS));
		Console cons = new Console(text, 10);
		System.setOut(new PrintStream(cons));
		console.add(playerInfo);
		console.add(new JScrollPane(text));
		frame.add(console, BorderLayout.SOUTH);
		
		frame.setSize(800,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		for(int i = 0; i < 50; i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void paint(Graphics g)
	{
		g.fillRect(0, 0, 800, 700);
	}
}
