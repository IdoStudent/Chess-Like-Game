package control;

import java.util.Collection;
import java.util.Scanner;

import model.GameEngine;
import model.Player;
import model.User;
import view.GameTextView;

public class GameControl {
	Scanner input = new Scanner(System.in);
				
	   private GameEngine model;
	   private GameTextView view;

	   public GameControl(GameEngine model, GameTextView view){
	      this.model = model;
	      this.view = view;
	   }


	   public void renderMenu(){
		   view.mainMenu();
	   }
	   
	   public void signup(String id, String pwd){
		   if (model.addUser(id, pwd)) {
			   	view.validSignupMessage();
			} else {
				view.errorSignupMessage();
			}
	   }
	   
	   public void login(String id, String pwd){
		   if (model.addPlayer(id, pwd)) {
				view.validLoginMessage();
				view.assignNumofMove();
				model.assignNumofMove(id, input.nextInt());
				model.addPieceToBoard(model.getPlayer(id));
			} else {
				view.errorLoginMessage();
			}
	   }
	   	   
	   public Collection<User> getAllUsers(){
		   return model.getAllUser();	
	   }
	   
	   public Player[] getAllPlayers(){
		   return model.getAllPlayers();	
	   }
	   
	   public boolean movePiece(String playerId, int fromX, int fromY, int toX, int toY){
		   Player player = model.getPlayer(playerId);
		   model.CombinablePiece piece = player.getPiece(fromX, fromY);
		   System.out.println(piece.getCombinedName());
		   System.out.println(piece.getName());
		   System.out.println(piece.getPieces().toString());

		   model.CombinablePiece piece2 = player.getPiece(toX, toY);
//		   System.out.println(piece2.getCombinedName());
//		   System.out.println(piece2.getName());
//		   System.out.println(piece2.getPieces().toString());
//		   
		   System.out.println(player.getAllPieces().toString());
		   
//		   System.out.println(model.getBoard().toString());

//		   return player.movePiece(model, piece, toX, toY);
		   System.out.println("test1:" + piece.combinedValidMove(toX, toY));
		   
		   return model.movePiece(piece, toX, toY);

		   
	   }
	   
	   public void unmergePiece(String playerId, String name, int fromX, int fromY, int toX, int toY){
		   Player player = model.getPlayer(playerId);
		   model.CombinablePiece piece1 = player.getPiece(fromX, fromY);
		   model.CombinablePiece piece2 = player.getPiece(toX, toY);

		   System.out.println(piece1.getCombinedName());
		   System.out.println(piece1.getName());
		   System.out.println(piece1.getPieces().toString());
		   System.out.println(player.getAllPieces().toString());
		   System.out.println(model.getBoard().toString());
		   
//		   return player.movePiece(model, piece, toX, toY);
		   model.unmergePiece(piece1, piece2, toX, toY);

		   
	   }

	   
	   
	   public void viewPiece(String playerId){
		   Player player = model.getPlayer(playerId);
		   System.out.println(player.getAllPieces().toString());
		   System.out.println(model.getBoard().toString());
		   
	   }

	}