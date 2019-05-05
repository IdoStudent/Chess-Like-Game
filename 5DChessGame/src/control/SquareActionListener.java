package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CombinablePiece;
import model.GameEngine;
import model.Square;
import view.GameEngineGUI;
import view.SquareBtn;

public class SquareActionListener implements ActionListener{
	private GameEngineGUI frame;
	private GameEngine model;
	private SquareBtn squareBtn;
	private Square square;
	private int x, y;
	private CombinablePiece piece;
	
	public SquareActionListener(SquareBtn squareBtn, GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.model = model;
		this.squareBtn = squareBtn;
		x = this.squareBtn.getPosX();
		y = this.squareBtn.getPosY();
		this.square = this.model.getBoard().getSquares(x, y);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CombinablePiece selectedPiece = this.model.getSelectedPiece();
		
			if (model.isGameOver()) {
				JOptionPane.showMessageDialog(frame, "GAME OVER\n" + "Result:\n" + this.model.getGameResult());
				frame.getChessBoard().disableBoard();

			} else {
				if (selectedPiece==null) { // Set the selected Piece
					if (square.getPiece()!=null) {
						int playerIndex = square.getPiece().getPlayer().getPlayerIndex();
						piece= this.model.getBoard().getSquares(x, y).getPiece();
						this.model.setSelectedPiece(piece);
						if (this.model.getTurn()==playerIndex)
						this.frame.getChessBoard().highlightValidMove(this.squareBtn);

						} 
				} else { // In case of a piece had been selected
					if (selectedPiece.getPosX()!=x || selectedPiece.getPosY()!=y) {
						 model.movePiece(selectedPiece, x, y);
						 frame.updateGameGUI();	 
						 this.model.setSelectedPiece(null);
						 this.frame.getChessBoard().removeHighLine();
		
					} else {
						 this.model.setSelectedPiece(null);
						 this.frame.getChessBoard().removeHighLine();
					}
				}

			}
	}

}
