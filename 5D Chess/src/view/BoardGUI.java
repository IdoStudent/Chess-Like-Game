package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardGUI extends JPanel{
	
	private JFrame frame;
	
	public BoardGUI()
	{
		renderWindow();
	}
	
	private void renderWindow()
	{
		frame = new JFrame();
		frame.setSize(800,700);
		frame.getContentPane().add(this);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.fillRect(0, 0, 600, 600);
	}
}
