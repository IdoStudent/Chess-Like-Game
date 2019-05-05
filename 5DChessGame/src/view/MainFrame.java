package view;

import javax.swing.JFrame;

// simple abstract class with a single concrete method to avoid code duplication in the layout examples
// Author: Caspar
public abstract class MainFrame extends JFrame
{
   public MainFrame(String string) {
		// TODO Auto-generated constructor stub
	}

// call this method after you have added components to the JFrame
   public void showFrame()
   {
      // set a fixed size (would normally read from config file)
      setBounds(100, 100, 800, 800);
      // so we can close the frame on exit (when 'x' clicked in UI)
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // make it visible
      setVisible(true);
   }
}