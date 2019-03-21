package Model;

import java.awt.image.BufferedImage;

import View.Frame;
import View.GameEngineGUI;

public class GameEngine {
	
	private GameEngineGUI gameEngineGUI;
	private Button[][] buttonArray = new Button[6][6]; //Squares
	private int row,col;
	private Pawn pawn;
	private int currentRow,currentCol,tempRow,tempCol;
	private boolean isPawnChosen = false;
	private Button tempButton;
	
	public GameEngine() {
		createButtonArray();//Create squares
		gameEngineGUI = new GameEngineGUI(buttonArray); //GUI
		pawn = new Pawn();//creates pawns
		initialConfig();//adds the pawns to the board
	}
	
	public void createButtonArray() {
		for (int i=0;i<36;i++) {
			Button button = new Button(row,col,this);
			buttonArray[row][col] = button;
			col++;
			if (col > 5) {
				col = 0;
				row++;
			}
		}
	}
	
	public void initialConfig() {
		setPawnPlacement(buttonArray[0][0], pawn.getBishhop().getImage("black"), "blackBishop");
		setPawnPlacement(buttonArray[0][1], pawn.getRook().getImage("black"), "blackRook");
		setPawnPlacement(buttonArray[0][2], pawn.getKnight().getImage("black"), "blackKnight");
		setPawnPlacement(buttonArray[0][3], pawn.getKnight().getImage("black"), "blackKnight");
		setPawnPlacement(buttonArray[0][4], pawn.getRook().getImage("black"), "blackRook");
		setPawnPlacement(buttonArray[0][5], pawn.getBishhop().getImage("black"), "blackBishop");
		setPawnPlacement(buttonArray[5][0], pawn.getBishhop().getImage("white"), "whiteBishop");
		setPawnPlacement(buttonArray[5][1], pawn.getRook().getImage("white"), "whiteRook");
		setPawnPlacement(buttonArray[5][2], pawn.getKnight().getImage("white"), "whiteKnight");
		setPawnPlacement(buttonArray[5][3], pawn.getKnight().getImage("white"), "whiteKnight");
		setPawnPlacement(buttonArray[5][4], pawn.getRook().getImage("white"), "whiteRook");
		setPawnPlacement(buttonArray[5][5], pawn.getBishhop().getImage("white"), "whiteBishop");
	}
	
	public void setPawnPlacement(Button button,BufferedImage image, String pawnName) {
		gameEngineGUI.setImage(button, image);
		button.setPawnName(pawnName);
	}
	
	public void action(Button currentButton) {
		System.out.println("ACTION");
		if (currentButton.getPawnName().isEmpty()) {
			if(isPawnChosen) {
				if(isValidMove(currentButton, tempButton.getPawnName())) {
					movePawn(currentButton);
				}
			}
			System.out.println("EMPTY");
		}else {
			if(isPawnChosen) {
				System.out.println("KILL EM ALL");
				killEmAll(currentButton);
			}else {
				isPawnChosen = true;
				tempButton = currentButton;
				System.out.println(currentButton.getPawnName());
			}
		}
	}
	
	public void killEmAll(Button currentButton) {
		movePawn(currentButton);
	}
	
	public void movePawn(Button currentButton) {
		System.out.println("MOVE PAWN");
		tempButton.removeImage();
		//currentButton.removeImage();
		currentButton.setImage(tempButton.getImage());
		isPawnChosen = false;
		currentButton.setPawnName(tempButton.getPawnName());
		tempButton.setPawnName("");
	}
	
    public boolean isValidMove(Button currentButton, String pawnName) {
    	updateRowsAndCols(currentButton);
    	if(pawnName.matches("blackBishop") || pawnName.matches("whiteBishop")) {
        	return pawn.getBishhop().validMove(tempRow , tempCol, currentRow, currentCol);
    	}else if(pawnName.matches("blackRook") || pawnName.matches("whiteRook")) {
    		return pawn.getRook().validMove(tempRow, tempCol, currentRow, currentCol);
    	}else if(pawnName.matches("blackKnight") || pawnName.matches("whiteKnight")) {
    		return pawn.getKnight().validMove(tempRow, tempCol, currentRow, currentCol);
    	}
    	return false;
    }
    
	public void updateRowsAndCols(Button currentButton) {
		currentRow = currentButton.getButtonRow();
		currentCol = currentButton.getButtonCol();
		tempRow = tempButton.getButtonRow();
		tempCol = tempButton.getButtonCol();
	}
}
