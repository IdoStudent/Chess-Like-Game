package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Button;
import Model.GameEngine;
import View.Frame;
import View.GameEngineGUI;

public class ButtonAction implements ActionListener{
	
	Button currentButton; //button pushed
	GameEngine gameEngine;
	//int currentRow,currentCol,tempRow,tempCol;
	//boolean isCurrentButtonWhite = true,isTempButtonWhite = true;
	
	public ButtonAction(GameEngine gameEngine, Button button) {
		this.currentButton = button;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		gameEngine.action(currentButton);
		
/*		if (currentButton.getImageName().isEmpty()) { //if empty button is pressed	
			if(gameEngineGUI.getPawnChosen()) { //and a pawn was previously chosen
				
				//Bishop
				if (whichPawn().matches("Bishop")) {
					updateRowsAndCols();
					System.out.println(currentButton);
					gameEngine.updateRowsAndCols(currentButton);
					if (currentRow == tempRow + 2 || currentRow == tempRow - 2) {
						if (currentCol == tempCol + 2 || currentCol == tempCol - 2) {
							movePawn();
						}
					}
				}
				
				//Rook
				if (whichPawn().matches("Rook")) { 
					updateRowsAndCols();
					if (currentRow == tempRow && (currentCol == tempCol + 2 || currentCol == tempCol - 2)) {
						movePawn();
					}else if(currentCol == tempCol && (currentRow == tempRow + 2 || currentRow == tempRow -2) ) {
						movePawn();
					}
				}
				
				//Knight
				if (whichPawn().matches("Knight")) { 
					updateRowsAndCols();
					if (currentRow == tempRow + 1 || currentRow == tempRow - 1) {
						if(currentCol == tempCol + 2 || currentCol == tempCol - 2) {
							movePawn();
						}
					}else if(currentRow == tempRow + 2 || currentRow == tempRow - 2) {
						if(currentCol == tempCol + 1 || currentCol == tempCol - 1) {
							movePawn();
						}
					}
				}
			}
		}else {//if a pawn is pressed
			if(gameEngineGUI.getPawnChosen()) {
				updateColors();
				System.out.println(isTempButtonWhite);
				System.out.println(isCurrentButtonWhite);
				if ((isTempButtonWhite == true && isCurrentButtonWhite == false) || (isTempButtonWhite == false && isCurrentButtonWhite == true)) {
					currentButton.removeImage();
					movePawn();
				}
			}else {
				gameEngineGUI.setPawnChosen(true);
				gameEngineGUI.setTempButton(currentButton);
			}
		}*/
	}
	
/*	public void updateRowsAndCols() {
		currentRow = currentButton.getButtonRow();
		currentCol = currentButton.getButtonCol();
		tempRow = gameEngineGUI.getTempButton().getButtonRow();
		tempCol = gameEngineGUI.getTempButton().getButtonCol();
	}
	
	public void movePawn() {
		gameEngineGUI.removeImage(); //removes previous button image
		currentButton.setImage(gameEngineGUI.getTempButton().getTempImage(),gameEngineGUI.getTempButton().getTempImageName()); //set the image on the new button
		gameEngineGUI.setPawnChosen(false);
	}
	
	public void updateColors() {
		
		if (getTempImageName().matches("blackKnight") || getTempImageName().matches("blackRook") || getTempImageName().matches("blackBishop")){
			isTempButtonWhite = false;
			//System.out.println("BLACK ATTACKS!");
		}else {
			//System.out.println("WHITE ATTACKS!");
		}
		
	    if(currentButton.getImageName().matches("blackKnight") || currentButton.getImageName().matches("blackRook") || currentButton.getImageName().matches("blackBishop")) {
			isCurrentButtonWhite = false;
			//System.out.println("BLACK UNDER ATTACK!");
		}else {
			//System.out.println("WHITE UNDER ATTACK!");
		}
	}
	
	public String whichPawn() {
		if (gameEngineGUI.getTempButton().getImageName().matches("blackBishop") || gameEngineGUI.getTempButton().getImageName().matches("whiteBishop")) {
			return "Bishop";
		}else if(gameEngineGUI.getTempButton().getImageName().matches("blackRook") || gameEngineGUI.getTempButton().getImageName().matches("whiteRook")) {
			return "Rook";
		}
		return "Knight";
	}
	
	public String getTempImageName() {
		return gameEngineGUI.getTempButton().getTempImageName();
	}*/

}
