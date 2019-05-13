package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class IO {

	GameEngine gameEngine;
	
	public IO(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		loadUserData();
	}
	
	public void loadUserData() {
		String filePath = "database.txt";
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(":", 4);
				if (parts.length >= 2) {
					String id = parts[0];
					String pwd = parts[1];
					gameEngine.addUser(id, pwd);
				}
			}
			reader.close();
		} catch (Exception e) {
			// Block of code to handle errors
		}
	}
	
	
}
