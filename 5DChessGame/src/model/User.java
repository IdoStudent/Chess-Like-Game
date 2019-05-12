package model;

import java.io.File;
import java.util.Scanner;

public class User {
	private String userId;
	private String userPwd;

	public User(String userId, String userPwd) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public User(String userId) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public boolean loginPlayer(String username, String password, GameEngine gameEngine)
	{
		//validate username and password,
		//check if username is already logged in,
		//create new player object,
		//run addPlayer method and pass in new player object
		
		if(checkUsernamePasswordCorrect(username, password) == false)
		{
			return false;
		}
		else
		{
			Player player = new Player(username);
			gameEngine.addUser(username, password);
			return true;
		}
	}
	
	public boolean registerPlayer(String username, String password,  GameEngine gameEngine)
	{
		//validate username and password,
		//check if username is already registered,
		//create new player object,
		//run addPlayer method and pass in new player object
		
		if(checkIfUsernameExists(username) == true)
		{
			return false;
		}
		else
		{
			if(requirements(username, password) == false)
			{
				return false;
			}
			else
			{
				Player player = new Player(username);
				gameEngine.addPlayer(username,username);
				gameEngine.writeDataToFile(username, password);
				return true;
			}
		}
	}
	
	private boolean checkUsernamePasswordCorrect(String username, String password)
	{
		Scanner inputStream = null;	
		try
		{
			inputStream = new Scanner(new File("database.txt"));
			inputStream.useDelimiter(":");
			
			while(inputStream.hasNextLine())
			{
				String user = inputStream.next();
				String pass = inputStream.next();
				
				if(user.equals(username) && pass.equals(password))
				{
					inputStream.close();
					return true;
				}
				
				inputStream.nextLine();
			}
			
			inputStream.close();
		} catch(Exception e) {
			return false;
		}
		return false;
	}
	
	private boolean checkIfUsernameExists(String username)
	{
		Scanner inputStream = null;	
		try
		{
			inputStream = new Scanner(new File("database.txt"));
			inputStream.useDelimiter(":");
			
			while(inputStream.hasNextLine())
			{
				String user = inputStream.next();
				
				if(user.equals(username))
				{
					inputStream.close();
					return true;
				}
				inputStream.nextLine();
			}
			
			inputStream.close();
		} catch(Exception e) {
			return true;
		}
		return false;
	}
	
	private boolean requirements(String username, String password)
	{
		if(username.length() > 10)
		{
			return false;
		}
		else if(username.contains(":") || password.contains(":"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
