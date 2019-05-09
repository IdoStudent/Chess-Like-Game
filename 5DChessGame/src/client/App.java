package client;

import model.GameEngine;
import view.LoginRegisterForm;

public class App {

	public static void main(String[] args) {
		// GUI code should run on the AWT Event dispatch/UI Thread

		// could use a Java 8 lambda
		// SwingUtilities.invokeLater(() -> new JHelloWorld());

		// but let's keep it explicit so we can see more clearly what is actually
		// happening!
		GameEngine gameEngine = new GameEngine();
		new LoginRegisterForm(gameEngine);
		
	}

}
