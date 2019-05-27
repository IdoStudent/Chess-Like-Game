package view;

import java.awt.Color;
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

public class MaxMovesForm extends JFrame{
	
	Panel panel;
	
	Label player;
	
	TextField maxMovesText = new TextField(10);
	
	JButton submitButton = new JButton("Submit");
	
	public MaxMovesForm(String player, GameEngine gameEngine)
	{
		this.player = new Label("Enter maximum moves: ( " + player + " )");
		this.renderGUI(player, gameEngine);
	}
	
	public void renderGUI(String playerID, GameEngine gameEngine)
	{
		
		panel = new Panel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.add(panel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(player);
		topPanel.add(maxMovesText);
		panel.add(topPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(submitButton);
		submitButton.addActionListener(new MaxMovesActionListener(playerID, gameEngine, maxMovesText, this));
		panel.add(bottomPanel);
		
		
		this.setSize(350,120);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void renderError()
	{
		this.setSize(300,150);
		Label error = new Label("ERROR: Enter number between 10 and 90!");
		error.setForeground(Color.RED);
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new FlowLayout());
		errorPanel.add(error);
		panel.add(errorPanel);
	}

}
