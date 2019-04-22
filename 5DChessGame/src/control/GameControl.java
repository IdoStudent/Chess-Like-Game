package control;

import java.util.Collection;
import java.util.Scanner;

import model.GameEngine;
import model.Player;
import model.User;
import view.GameView;

public class GameControl {
	Scanner input = new Scanner(System.in);
				
	   private GameEngine model;
	   private GameView view;

	   public GameControl(GameEngine model, GameView view){
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
		   System.out.println(player.getAllPieces().toString());
		   System.out.println(model.getBoard().toString());

//		   return player.movePiece(model, piece, toX, toY);
		   return model.movePiece(piece, toX, toY);

		   
	   }
	   
	   public void unmergePiece(String playerId, String name, int fromX, int fromY, int toX, int toY){
		   Player player = model.getPlayer(playerId);
		   model.CombinablePiece piece = player.getPiece(fromX, fromY);
		   System.out.println(piece.getCombinedName());
		   System.out.println(piece.getName());
		   System.out.println(piece.getPieces().toString());
		   System.out.println(player.getAllPieces().toString());
		   System.out.println(model.getBoard().toString());
		   
//		   return player.movePiece(model, piece, toX, toY);
		   model.unmergePiece(piece, name, toX, toY);

		   
	   }

	   
	   
	   public void viewPiece(String playerId){
		   Player player = model.getPlayer(playerId);
		   System.out.println(player.getAllPieces().toString());
		   System.out.println(model.getBoard().toString());
		   
	   }

	}