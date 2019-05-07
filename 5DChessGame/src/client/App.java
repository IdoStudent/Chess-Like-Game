package client;

import javax.swing.SwingUtilities;

import view.GameEngineGUI;

public class App {

	public static void main(String[] args) {
		// GUI code should run on the AWT Event dispatch/UI Thread

		// could use a Java 8 lambda
		// SwingUtilities.invokeLater(() -> new JHelloWorld());

		// but let's keep it explicit so we can see more clearly what is actually
		// happening!
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameEngineGUI();
			}

		});
	}

}
