package view;

import model.User;
import java.util.Scanner;

import control.GameControl;
import model.GameEngine;
import model.Player;

public class GameView {
	Scanner input = new Scanner(System.in);
	GameEngine model = new GameEngine();

	GameControl controller = new GameControl(model, this);

	public GameView() {
		// TODO Auto-generated constructor stub
	}
	public void signup() {
		System.out.println("Enter username");
		String id= input.nextLine();
		System.out.println("Enter password");
		String pwd = input.nextLine();
		controller.signup(id, pwd);
	}
	
	public void login() {
		System.out.println("Enter username");
		String id= input.nextLine();
		System.out.println("Enter password");
		String pwd = input.nextLine();
		controller.login(id, pwd);
	}
	
	public void errorLoginMessage() {
		System.out.println("Invalid user");
	}
	
	public void validLoginMessage() {
		System.out.println("Login successfully");
	}
	
	public void errorSignupMessage() {
		System.out.println("Dupplicated user");
	}
	
	public void validSignupMessage() {
		System.out.println("Signup successfully");
	}
	
	public void assignNumofMove() {
		System.out.println("Enter number of move");
	}
	
	
	public void viewAllUsers() {
		// Iterate through all player and concatenate the final score of each player to a string
		   for (User user : model.getAllUser())
		      {
				System.out.println(user.getUserId() +"  "+user.getUserPwd());
		      }
	}
	
	public void viewAllPlayers() {
		// Iterate through all player and concatenate the final score of each player to a string
		   for (Player player : model.getAllPlayers())
		      {
				System.out.println(player.getUserId() +"  "+player.getUserPwd());
		      }
		   
	}
	
	public void renderBoard() {
		for (int i=0;i<model.getBoard().getHeight();i++) {
			for (int j=0;j<model.getBoard().getWidth();j++) {
				System.out.print(model.getBoard().getSquares(i,j).getName());
			}
			System.out.print("\n");	
		}	
	}
	
	public void startGame() {
			
	}
	
	public void endGame() {
		
	}
	
	public void movePiece() {
		
	}
	
	
	public char menu()
	   {
	      System.out.println("\n\nChess Game\n");
	      System.out.format("%-20s - %4d\n","Signup",0);
	      System.out.format("%-20s - %4d\n","Login",1);
	      System.out.format("%-20s - %4d\n","View Board",2);
	      System.out.format("%-20s - %4d\n","Start Game",3);
	      System.out.format("%-20s - %4d\n","Move Piece",4);
	      System.out.format("%-20s - %4d\n","View all members",5);
	      System.out.format("%-20s - %4d\n","View all players",6);
	      System.out.format("%-20s - %4d\n","End Game",7);
	      System.out.println("\n**************************************");
	      System.out.print("Your choice : " );
	      char ch = input.nextLine().charAt(0);
	      return ch;
	   }
	
	public void mainMenu()
	   {
	      char ch;
	      do { 
	        ch = menu(); 
	        if ( ch > '2' && ch < '7' && model.getAllPlayers() == null)
	        {  System.out.println("Login first to commence a Game"); 
	        	ch = input.nextLine().charAt(0);
	        } else {
	            switch (ch)
	            {
	              case '0' : this.signup();
	                   break;
	              case '1' : this.login();
	                   break;
	              case '2' : this.renderBoard();
	                   break;
	              case '3' : this.startGame();
	                   break;
	              case '4' : this.movePiece();
	                   break;
	              case '5' : this.viewAllUsers();
                  		break;
	              case '6' : this.viewAllPlayers();
                  		break;
	              case '7' : this.endGame();
	                   break;
	            }
	          }
	       }  while ( ch != '7');         
	   }
}
