package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

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
	
	public void writeDataToFile(String username, String password) {
		Scanner scanner;
		StringBuilder sb = new StringBuilder();
		try {
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while (scanner.hasNextLine()) {
				if (sb.length() != 0) {
					sb.append("\n");
				}
				String user = scanner.next();
				String pass = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());
				sb.append(user + ":" + pass + ":" + win + ":" + loss + ":");
				scanner.nextLine();
			}
			scanner.close();
		} catch (Exception e) {
		}
		try {
			PrintWriter out = new PrintWriter("database.txt");

			out.println(sb);
			out.print(username + ":" + password + ":" + 0 + ":" + 0 + ":");
			out.close();
		} catch (FileNotFoundException e) {
		}
	}
	
}
