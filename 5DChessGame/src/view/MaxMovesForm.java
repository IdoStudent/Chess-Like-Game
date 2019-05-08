package view;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.MaxMovesActionListener;
import model.GameEngine;

public class MaxMovesForm {
	
	JFrame frame;
	Panel panel;
	
	Label player;
	
	TextField maxMovesText = new TextField(10);
	
	JButton submitButton = new JButton("Submit");
	
	public MaxMovesForm(String player)
	{
		this.player = new Label(player + " enter maximum moves:");
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		
		frame = new JFrame();
		panel = new Panel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.add(panel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(player);
		topPanel.add(maxMovesText);
		panel.add(topPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(submitButton);
		submitButton.addActionListener(new MaxMovesActionListener(gameEngine, maxMovesText, this));
		panel.add(bottomPanel);
		
		
		frame.setSize(300,100);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
