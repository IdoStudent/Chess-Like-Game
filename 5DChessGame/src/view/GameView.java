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
		for (int y=0;y<model.getBoard().getWidth();y++) {
			for (int x=0;x<model.getBoard().getHeight();x++) {
				System.out.print(model.getBoard().getSquares(x,y).getName());
			}
			System.out.print("\n");	
		}	
		
	}
	
	public void startGame() {
			
	}
	
	public void endGame() {
		
	}
	
	public void movePiece() {
		System.out.println("Enter player ID");
		String playerId = input.nextLine();
		System.out.print("Enter the current X coordinate of the piece (X)");
		int fromX = input.nextInt();
		System.out.println(fromX);

		System.out.print("Enter the current Y coordinate of the piece (Y)");
		int fromY = input.nextInt();
		System.out.println(fromY);

		System.out.print("Move piece to a new X coordinate (X)");
		int toX = input.nextInt();
		System.out.println(toX);

		System.out.print("Move piece to a new Y coordinate(Y)");
		int toY = input.nextInt();
		System.out.println(toY);

		System.out.println(fromX + "-" +fromY + "-"  +toX+ "-" +toY);
	    input.nextLine();

	    System.out.print(controller.movePiece(playerId, fromX, fromY, toX,toY));

	}
	
	public void viewPiece() {
		System.out.println("Enter player ID");
		String playerId = input.nextLine();
		controller.viewPiece(playerId);
		
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
	      System.out.format("%-20s - %4d\n","View Pieces",7);
	      System.out.format("%-20s - %4d\n","Unmerge A Piece",8);
	      System.out.format("%-20s - %4d\n","End Game",9);
	      System.out.println("\n**************************************");
	      System.out.println("Your choice : " );
	      char ch = input.nextLine().charAt(0);
	      return ch;
	   }
	
	public void mainMenu()
	   {
	      char ch;
	      do { 
	        ch = menu(); 
	        if ( ch > '2' && ch < '9' && model.getAllPlayers() == null)
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
	              case '7' : this.viewPiece();
            		break;
	              case '8' : this.unmergePiece();
          			break;
	              case '9' : this.endGame();
	                   break;
	            }
	          }
	       }  while ( ch != '9');         
	   }
	private void unmergePiece() {
		// TODO Auto-generated method stub
		System.out.println("Enter player ID");
		String playerId = input.nextLine();
		System.out.print("Enter the current X coordinate of the piece (X)");
		int fromX = input.nextInt();
		System.out.println(fromX);

		System.out.print("Enter the current Y coordinate of the piece (Y)");
		int fromY = input.nextInt();
		System.out.println(fromY);

		System.out.print("Unmerge piece to a new X coordinate (X)");
		int toX = input.nextInt();
		System.out.println(toX);

		System.out.print("Unmerge piece to a new Y coordinate(Y)");
		int toY = input.nextInt();
		System.out.println(toY);

		
		System.out.print("Unmerge piece Name");
		String name = input.next();
		System.out.println(name);
	    input.nextLine();

	    controller.unmergePiece(playerId, name, fromX, fromY, toX,toY);
	}
}
