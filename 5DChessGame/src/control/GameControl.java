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
	   
//	   public void renderBoard(){
//		   return model.getAllPlayers();	
//	   }


	}