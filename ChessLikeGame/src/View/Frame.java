package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import Model.Button;
import Model.GameEngine;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Frame {
	
	private JFrame jframe;
	private Menu menu;
	private Board board;
	
	public Frame(GameEngine gameEngine) {
		
		jframe = new JFrame("Chess-like Game");
		jframe.setBounds(100, 100, 725, 700);
		jframe.setLayout(new BorderLayout());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new Menu(gameEngine);

		board = new Board();
	}
	
 	public void addButtonsToFrame(Button[][] buttonArray) {
 		board.addButtonsToFrame(buttonArray);
 		jframe.add(board.getPanel());
		jframe.setJMenuBar(menu.getMenuBar());
		jframe.setVisible(true);
	}

}
