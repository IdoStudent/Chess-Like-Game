package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class ErrorAction implements ActionListener{

	JDialog frame;
	
	public ErrorAction(JDialog frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}

}
