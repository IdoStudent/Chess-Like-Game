package view;
import java.awt.*;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.GameEngine;


public class GameEngineGUI {
	private GameEngine model = new GameEngine();



	public GameEngineGUI() {
		// TODO Auto-generated constructor stub
		// Set the title of the frame
		// the frame that contains the close component
 
	}


	public void renderGameGUI() {
		
		renderLoginRegister("Player 1");
		while(model.getAllPlayers()[0] == null) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		renderLoginRegister("Player 2");
		while(model.getAllPlayers()[1] == null) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		renderMaxMoves("Player 1");
		while(model.getAllPlayers()[0].getNumOfMove() == 0) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		renderMaxMoves("Player 2");
		while(model.getAllPlayers()[1].getNumOfMove() == 0) {try {Thread.sleep(500);} catch (InterruptedException e) {}}
		
		renderGame();
		
		System.out.println("Game started...");
		System.out.println("Credits to: Anna Tran, Walaa Aqeel, Brandon Sarkis, Ido Yaron & Yasir Fayrooz.");
		System.out.println("Max moves is calculated by the average of Player 1: " + model.getAllPlayers()[0].getNumOfMove() + " and Player 2: " + model.getAllPlayers()[1].getNumOfMove());
        
	}
	
	private void renderGame()
	{
		GameGUI game = new GameGUI(this, model);
		game.renderGUI(model);
	}
	
	private void renderLoginRegister(String player)
	{
		LoginRegisterForm loginRegister = new LoginRegisterForm(player);
		loginRegister.renderGUI(model);
	}
	
	private void renderMaxMoves(String player)
	{
		MaxMovesForm maxMoves = new MaxMovesForm(player);
		maxMoves.renderGUI(model);
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
