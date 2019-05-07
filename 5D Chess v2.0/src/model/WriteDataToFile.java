package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteDataToFile {
	
	public WriteDataToFile(Player winner, GameEngine gameEngine)
	{
		int winnerIndex = 1;
		int loserIndex = 0;
		if(gameEngine.getPlayers()[0].equals(winner))
		{
			winnerIndex = 0;
			loserIndex = 1;
		}
		
		Scanner scanner;
		StringBuilder sb = new StringBuilder();
		try
		{
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while(scanner.hasNextLine())
			{
				if(sb.length() != 0)
				{
					sb.append("\n");
				}
				
				String username = scanner.next();
				String password = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());
				
				if(username.equals(gameEngine.getPlayers()[winnerIndex].getPlayerId()))
				{
					if(winner != null)
					win++;
				}
				else if(username.equals(gameEngine.getPlayers()[loserIndex].getPlayerId()))
				{
					if(winner != null)
					loss++;
				}
				
				sb.append(username + ":" + 
						  password + ":" + 
						  win + ":" + 
						  loss + ":");
				
				scanner.nextLine();
			}
			scanner.close();
		}
		catch(Exception e){}
		
		try 
		{
			PrintWriter out = new PrintWriter("database.txt");
			
			out.print(sb);
			out.close();
		}
		catch (FileNotFoundException e) {}
		
		System.exit(0);
	}
	
	public WriteDataToFile(String username, String password)
	{
		Scanner scanner;
		StringBuilder sb = new StringBuilder();
		try
		{
			scanner = new Scanner(new File("database.txt"));
			scanner.useDelimiter(":");
			while(scanner.hasNextLine())
			{
				if(sb.length() != 0)
				{
					sb.append("\n");
				}
				
				String user = scanner.next();
				String pass = scanner.next();
				int win = Integer.parseInt(scanner.next());
				int loss = Integer.parseInt(scanner.next());
				
				sb.append(user + ":" + 
						  pass + ":" + 
						  win + ":" + 
						  loss + ":");
				
				scanner.nextLine();
			}
			scanner.close();
		}
		catch(Exception e){}
		
		try 
		{
			PrintWriter out = new PrintWriter("database.txt");
			
			out.println(sb);
			out.print(username + ":" + password + ":" + 0 + ":" + 0 + ":");
			out.close();
		}
		catch (FileNotFoundException e) {}
	}

}
