package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.ButtonAction;
import View.GameEngineGUI;

public class Button{
	
	private JButton jbutton;
	private JButton[][] jbuttons = new JButton[6][6]; //buttons
	int buttonRow,buttonCol;
	private String pawnName = "";
	private BufferedImage image;
	
	public Button(int row, int col, GameEngine gameEngine) { //Constructor	
		
		jbutton = new JButton(); //creates jbuttons
		jbuttons[row][col] = jbutton;//puts in array
		buttonRow = row;//saves button row
		buttonCol = col;//saves button column
		
		jbutton.addActionListener(new ButtonAction(gameEngine,this));	//adds a listener
	}
	
	public JButton getButton() {
		return jbutton;
	}
	
	public int getButtonRow() {
		return buttonRow;
	}
	
	public int getButtonCol() {
		return buttonCol;
	}
	
	public void setImage(BufferedImage image) {
		jbutton.setIcon(new ImageIcon(image));
		this.image = image;
	}
	
	public void removeImage() {
		jbutton.setIcon(null);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setPawnName(String pawnName) {
		this.pawnName = pawnName;
	}
	
	public String getPawnName() {
		return pawnName;
	}
	

}
