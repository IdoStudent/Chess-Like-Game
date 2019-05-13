package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.MergedPiece;
import model.GameEngine;
import model.Piece;
import model.Square;
import view.GameEngineGUI;
import view.GameEngineGUI;
import view.SquareBtn;

public class SquareActionListener implements ActionListener {
	
	private GameEngineGUI gameEngineGUI;
	private GameEngine gameEngine;
	private SquareBtn squareBtn;
	private Square square;
	private int x, y;
	private Piece piece;

	public SquareActionListener(SquareBtn squareBtn, GameEngineGUI gameEngineGUI, GameEngine gameEngine) {
		this.gameEngineGUI = gameEngineGUI;
		this.gameEngine = gameEngine;
		this.squareBtn = squareBtn;
		x = squareBtn.getPosX();
		y = squareBtn.getPosY();
		square = gameEngine.getBoard().getSquares(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Piece selectedPiece = gameEngine.getSelectedPiece();
		System.out.println(gameEngine.isGameOver());

		boolean moveResult = false;

		if (gameEngine.isGameOver()) { //check if game is over
			JOptionPane.showMessageDialog(gameEngineGUI, "GAME OVER\n" + "Result:\n" + gameEngine.getGameResult());
			gameEngineGUI.getChessBoard().disableBoard();
		} else {
			if (selectedPiece == null) { // if no piece was selected
				if (square.getPiece() != null) { //if square is not empty
					piece = gameEngine.getBoard().getSquares(x, y).getPiece();
					gameEngine.setSelectedPiece(piece); //pick piece
					if (gameEngine.getCurrentTurn() == square.getPiece().getPlayer().getPlayerIndex()) // if piece belongs to player
						gameEngineGUI.getChessBoard().highlightValidMove(squareBtn); //highlight potential moves
					System.out.println(piece.getClass().getName());
					System.out.println(piece.getName());
				}
			} else { // In case of a piece had been selected
				if (selectedPiece.getPosX() != x || selectedPiece.getPosY() != y) { //if not the same as selected piece
					moveResult = gameEngine.movePiece(selectedPiece, x, y);	// ??? move
					gameEngineGUI.updateGameGUI(); //update GUI
					gameEngine.setSelectedPiece(null);
					gameEngineGUI.getChessBoard().removeHighLine();
					// Logging to the console
					System.out.println(selectedPiece.getClass().getName());
					System.out.println("name:" + selectedPiece.getName());
					System.out.println("Selected [x,y] " + selectedPiece.getPosX() + ":" + selectedPiece.getPosY());
					System.out.println("Move Result:" + moveResult);
					System.out.println("Current turn:" + this.gameEngine.getCurrentTurn());
				}
			}
		}
	}
}
