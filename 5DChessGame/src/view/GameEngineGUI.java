package view;
import java.awt.*;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.GameEngine;


public class GameEngineGUI extends JFrame{
	private GameEngine model = new GameEngine();
	private ChessBoard chessBoard;
	private JTextArea console;
    private ScorePanel scorePanel;


	public GameEngineGUI() {
		// TODO Auto-generated constructor stub
		// Set the title of the frame
		super("Chess Like Game");
		this.renderGameGUI();  
		// the frame that contains the close component
        
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the frame
        this.setSize(1200, 1000);
        // Place the frame at the center of the screen.
        this.setLocationRelativeTo(null); 
        // make it visible
        this.setVisible(true);
 
	}


	public void renderGameGUI() {
        this.setLayout(new BorderLayout());
        
		chessBoard = new ChessBoard(this, this.model);
        chessBoard.setPreferredSize(new Dimension(600, 600));
		add(chessBoard, BorderLayout.CENTER);

		scorePanel = new ScorePanel(this, this.model);      
		add(scorePanel, BorderLayout.EAST);	
		
		console = new JTextArea("Test Area");
		console.setPreferredSize(new Dimension(0,100));
		add(console, BorderLayout.SOUTH);
        
	}
	
	public void updateGameGUI() {
        
		chessBoard.drawBoardPieces();   
		scorePanel.updateScoreInfo();
	}
		
	
	public GameEngine getModel() {
		return model;
	}
	
    public ChessBoard getChessBoard() {
		return chessBoard;
	}
    
	public ScorePanel getScorePanel() {
		return scorePanel;
	}

}
