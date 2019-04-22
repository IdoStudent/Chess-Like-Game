package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import conroller.MaxMovesAction;
import model.GameEngine;

public class MaxMovesGUI {
	JFrame frame;
	Panel panel;
	
	Label player;
	
	TextField maxMoves = new TextField(10);
	
	JButton submitButton = new JButton("Submit");
	
	public MaxMovesGUI(String player)
	{
		this.player = new Label(player + " enter maximum moves:");
	}
	
	public void renderGUI(GameEngine gameEngine)
	{
		submitButton.addActionListener(new MaxMovesAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int max = 0;
				try
				{
					max = Integer.parseInt(maxMoves.getText());
				} catch(Exception x) {}
				if(max >= 10 && max <= 90)
				{
					gameEngine.setMaxMoves(max);
					frame.dispose();
				}
				else
				{
					renderError();
				}
			}
		});
		
		frame = new JFrame();
		panel = new Panel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.add(panel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(player);
		topPanel.add(maxMoves);
		panel.add(topPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(submitButton);
		panel.add(bottomPanel);
		
		
		frame.setSize(300,100);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void renderError()
	{
		frame.setSize(300,150);
		Label error = new Label("ERROR: Enter number between 10 and 150!");
		error.setForeground(Color.RED);
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new FlowLayout());
		errorPanel.add(error);
		panel.add(errorPanel);
	}

}
