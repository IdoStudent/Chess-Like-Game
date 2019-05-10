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

public class GameEngineGUI extends JFrame {

	private GameEngine gameEngine;
	private ChessBoard chessBoard;
	private ScorePanel scorePanel;
	private Panel console;


	private JTextArea text = new JTextArea(7, 70);

	public GameEngineGUI(GameEngine gameEngine) {
		// this = new JFrame("5D Chess");
		super("5D Chess Like Game");
		this.gameEngine = gameEngine;

		this.setLayout(new BorderLayout());
		this.getContentPane();
		this.setBackground(Color.LIGHT_GRAY);
		this.renderGameGUI();
		this.setSize(1200, 1000);
		this.setLocationRelativeTo(null);
		// this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void renderGameGUI() {

		// Center chess board
		chessBoard = new ChessBoard(this, this.gameEngine);
		chessBoard.setPreferredSize(new Dimension(600, 600));
		this.add(chessBoard, BorderLayout.CENTER);

		// West score panel
		scorePanel = new ScorePanel(this, this.gameEngine);
		this.add(scorePanel, BorderLayout.WEST);

		// South panel which includes the console
		console = new Panel();
		console.setLayout(new BoxLayout(console, BoxLayout.PAGE_AXIS));
		Console cons = new Console(text, 10);
		System.setOut(new PrintStream(cons));
		console.add(new JScrollPane(text));
		this.add(console, BorderLayout.SOUTH);
		System.out.println("Game started...");
		System.out.println("Credits to: Anna Tran, Walaa Aqeel, Brandon Sarkis, Ido Yaron & Yasir Fayrooz.");
		System.out.println(
				"Max moves is calculated by the average of Player 1: " + gameEngine.getAllPlayers()[0].getNumOfMove()
						+ " and Player 2: " + gameEngine.getAllPlayers()[1].getNumOfMove());

	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void updateGameGUI() {
		this.getChessBoard().drawBoardPieces();
		scorePanel.updateScoreInfo();
	}
}
