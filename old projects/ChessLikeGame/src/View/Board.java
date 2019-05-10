package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Button;

public class Board {
	
	private JPanel panel;
	
	public Board() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,6));
		panel.setBounds(100, 100, 700, 700);
	}
	
 	public void addButtonsToFrame(Button[][] buttonArray) {
		int row = 0, col = 0;
		for (int i=0;i<36;i++) {
			buttonArray[row][col].getButton().setBorder(BorderFactory.createLineBorder(Color.BLACK)); //set borders on buttons
			if (i==0 || i==2 || i==4 || i==7 || i==9 || i==11 || i==12 || i==14 || i==16 || i==19 || i==21 //color some buttons 
				|| i==23 || i==24 || i==26 || i==28 || i==31 || i==33 || i==35) {
			    buttonArray[row][col].getButton().setBackground(Color.GRAY);
			}
		    panel.add(buttonArray[row][col].getButton());//add to frame
			col++;
			if (col > 5) {
				col = 0;
				row++;
			}
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}
