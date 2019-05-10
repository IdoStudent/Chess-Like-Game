package View;

import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import Model.Button;
import Model.GameEngine;

public class GameEngineGUI {
	
	private Frame frame;

	public GameEngineGUI(GameEngine gameEngine, Button[][] buttonArray) {
		frame = new Frame(gameEngine);//creates the board
		frame.addButtonsToFrame(buttonArray);
	}
	
	public String getPlayerName() {
		return JOptionPane.showInputDialog("Insert Player Name:");
	}
	
	public Frame getFrame() {
		return frame;
	}
	
	public void setImage(Button button,BufferedImage image) {
		button.setImage(image);
	}

}
