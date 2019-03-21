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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Frame {
	
	private JFrame jframe;
	
	public Frame() {
		
		jframe = new JFrame("Chess-like Game");
		jframe.setBounds(100, 100, 700, 700);
		jframe.setLayout(new GridLayout(6,6));
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
 	public void addButtonsToFrame(Button[][] buttonArray) {
		int row = 0, col = 0;
		for (int i=0;i<36;i++) {
			buttonArray[row][col].getButton().setBorder(BorderFactory.createLineBorder(Color.BLACK)); //set borders on buttons
			if (i==0 || i==2 || i==4 || i==7 || i==9 || i==11 || i==12 || i==14 || i==16 || i==19 || i==21 //color some buttons 
				|| i==23 || i==24 || i==26 || i==28 || i==31 || i==33 || i==35) {
			    buttonArray[row][col].getButton().setBackground(Color.GRAY);
			}
		    jframe.add(buttonArray[row][col].getButton());//add to frame
			col++;
			if (col > 5) {
				col = 0;
				row++;
			}
		}
		jframe.setVisible(true);
	}

}
