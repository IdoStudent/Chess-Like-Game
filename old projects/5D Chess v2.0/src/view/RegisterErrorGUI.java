package view;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ErrorAction;

public class RegisterErrorGUI extends JDialog{
	
	public RegisterErrorGUI(JFrame frame) 
	{
		
		super(frame, "", Dialog.ModalityType.DOCUMENT_MODAL);
		
		add(registerError());
		
		setSize(350,250);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	private Panel registerError()
	{
		
		Panel centerText = new Panel();
		centerText.setLayout(new FlowLayout());		
		centerText.add(new JLabel("ERROR due to one of the following:"));
		
		Panel errorType1 = new Panel();
		errorType1.setLayout(new FlowLayout());		
		errorType1.add(new JLabel("1. Username already exists in the system."));
		
		Panel errorType2 = new Panel();
		errorType2.setLayout(new FlowLayout());		
		errorType2.add(new JLabel("2. Username or password includes illegal character \':\' "));
		
		Panel errorType3 = new Panel();
		errorType3.setLayout(new FlowLayout());		
		errorType3.add(new JLabel("3. Username must be 10 characters or less."));
		
		Panel centerButton = new Panel();
		centerButton.setLayout(new FlowLayout());
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ErrorAction(this));
		centerButton.add(okButton);
		
		Panel errorPanel = new Panel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.PAGE_AXIS));
		errorPanel.add(centerText);
		errorPanel.add(errorType1);
		errorPanel.add(errorType2);
		errorPanel.add(errorType3);
		errorPanel.add(centerButton);
		
		return errorPanel;
	}
}
