package View;

import java.awt.image.BufferedImage;

import Model.Button;

public class GameEngineGUI {
	
	private Frame frame;

	public GameEngineGUI(Button[][] buttonArray) {
		frame = new Frame();//creates the board
		frame.addButtonsToFrame(buttonArray);
	}
	
	public Frame getFrame() {
		return frame;
	}
	
	public void setImage(Button button,BufferedImage image) {
		button.setImage(image);
	}

}
