package view;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.SquareActionListener;
import model.Board;
import model.CombinablePiece;
import model.GameEngine;
import model.Square;

public class ChessBoard extends JPanel {
	private SquareBtn[][] squareBtn ;
	private int row;
	private int column;

	GameEngineGUI frame;
	GameEngine model;

	public ChessBoard(GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.model = model;
		this.row = frame.getModel().getBoard().getHeight();
		this.column =frame.getModel().getBoard().getWidth();
//		this.squareBtn = new JButton[this.row][this.column];
		this.squareBtn = new SquareBtn[row][column];
	    this.setLayout(new GridLayout(row,column, 1, 1));
	    this.initBoard();
	}


	public  SquareBtn getSquare(int x, int y){
 		return this.squareBtn[x][y];
 	}
	
	public SquareBtn[][] getArraySquareBtn() {
		return squareBtn;
	}

	public void initBoard() {
		 // add JButtons dynamically
        for(int y=0; y < this.row; y++) {
        	for (int x=0; x<this.column; x++) {
        		squareBtn[x][y] = new SquareBtn(frame, model, x,y);
        		SquareActionListener squareActionListener = new SquareActionListener(squareBtn[x][y], frame,model);
        		squareBtn[x][y].addActionListener(squareActionListener);
//        		squareBtn[x][y].setLabel("["+x+y+"]");
                if (y%2==0) {
                	if (x%2==0) {
                    	squareBtn[x][y].setBackground(Color.GRAY);

                	} else {
                    	squareBtn[x][y].setBackground(Color.LIGHT_GRAY);
                	}
                } else {
                	if (x%2==0) {
                    	squareBtn[x][y].setBackground(Color.LIGHT_GRAY);
                	} else {
                    	squareBtn[x][y].setBackground(Color.GRAY);
                	}
                }
               
                
                this.add(squareBtn[x][y]);
        	}   
        }
	}
	
	 public void drawBoardPieces() { 	
		
		 Square square[][] = this.model.getBoard().getAllSquares();
	        for(int y = 0; y< column; y++) {
	            for(int x = 0; x < row; x++) {
	                Square sq = square[x][y];
	                if (sq.getPiece()!=null){
	                	setIconToSquare(x,y,sq);
	                } else {
	                	clearSquareIcon(x,y,sq);
	                }
	            }
	        }        
	        
	  }
	 
	 public void disableBoard() { 	
			
	        for(int y = 0; y< column; y++) {
	            for(int x = 0; x < row; x++) {
	            	squareBtn[x][y].setEnabled(false);
	            }
	        }        
	        
	  }
	 
	 public void highlightValidMove(SquareBtn sqr) {
		 int x = sqr.getPosX();
		 int y = sqr.getPosY();
		 Square square = this.model.getBoard().getAllSquares()[x][y];
		 CombinablePiece p = square.getPiece();
		 for (int i = 0; i < column; i++) {
			 for (int j = 0; j < row; j++) {
				 if (p.combinedValidMove(i, j)) {
					 squareBtn[i][j].setBorder(new LineBorder(Color.RED,2));
				 }
			 }
		 }
		 sqr.setBorder(new LineBorder(Color.ORANGE,2));

	 }
	 
	 public void removeHighLine() {
		 int x = row;
		 int y = column;
		 for (int i=0;i<x;i++) {
			 for (int j=0;j<y;j++) {
					 squareBtn[i][j].setBorder(null);
			 }
		 }
	 }
	private void setIconToSquare(int x, int y, Square sq) {
		// TODO Auto-generated method stub
		String pieceName = sq.getPiece().getCombinedName() + sq.getPiece().getColor();
		ImageIcon pieceIcon = new ImageIcon("img/" + pieceName + ".png");
		this.squareBtn[x][y].setIcon(pieceIcon);
		
	}

	private void clearSquareIcon(int x, int y, Square sq) {
		this.squareBtn[x][y].setIcon(null);
		
	}

	public void setArrayBtn(SquareBtn[][] arrayBtn) {
		this.squareBtn = arrayBtn;
	}
}



