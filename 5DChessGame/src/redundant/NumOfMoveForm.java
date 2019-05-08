package redundant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.GameEngine;

@SuppressWarnings("serial")
public class NumOfMoveForm extends JFrame implements ActionListener
{
	private JLabel labelNumOfMove;
	private JTextField numOfMove;
	private JButton submit;
	private GameEngineGUI frame;
	private GameEngine model;
	private String playerId;


	public NumOfMoveForm(String playerId, GameEngineGUI frame, GameEngine model) {
		// TODO Auto-generated constructor stub
		super("Login Form");
		this.frame = frame;
		this.model = model;
		this.playerId = playerId;

		labelNumOfMove = new CustomJLabel("Number of moves:");
		numOfMove = new JTextField();
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
		labelNumOfMove.setBounds(80, 70, 200, 30);
		numOfMove.setBounds(80, 110, 200, 30);
		submit.setBounds(300, 160, 100, 40);

		submit.addActionListener(this);

	   
		this.add(labelNumOfMove);
		this.add(numOfMove);
		this.add(submit);


		this.setLayout(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the frame
        this.setSize(600, 300);
        // Place the frame at the center of the screen.
        this.setLocationRelativeTo(null); 
        // make it visible
        this.setVisible(true);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {
			// the String to int conversion happens here

			int num = Integer.parseInt(numOfMove.getText());
			if (num > 0) {
		        this.setVisible(false);	
				model.assignNumofMove(playerId, num);
				model.addPieceToBoard(model.getPlayer(playerId));
				if (model.getNumOfPlayers()==2) {
					this.model.StartGame();
				}
				this.frame.updateGameGUI();
			
			} else {
				JOptionPane.showMessageDialog(this, "Negative number! Try again", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Invalid number format! Try again", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
