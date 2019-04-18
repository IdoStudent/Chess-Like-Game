package model;

public class GameEngine {
	
	private Piece[] pieces;
	private Player[] players = new Player[2];
	
	private int maxMoves = 0;
	private boolean playerTurn = true;
	
	public GameEngine()
	{
		renderLoginRegisterGUI();
		//this.maxMoves = maxMoves();
		setPieces();
	}
	
	private void renderLoginRegisterGUI()
	{
		//Render the GUI,
		//run loginPlayer or registerPlayer method depending on what player1 clicks
		//ONCE LOGGED IN SUCCESSFUL, run this method again for player2!!!!
		//run loginPlayer or registerPlayer method depending on what player2 clicks
	}
	
	public void loginPlayer(String username, String password)
	{
		//validate username and password,
		//check if username is already logged in,
		//create new player object,
		//run addPlayer method and pass in new player object
	}
	
	public void registerPlayer(String username, String password)
	{
		//validate username and password,
		//check if username is already registered,
		//create new player object,
		//run addPlayer method and pass in new player object
	}
	
	private boolean validatePlayers(String username, String password)
	{
		//check and see if the username and password requirements are correct and not blank
		//exclude using the char ":" from usernames and passwords as this will cause conflicts
		//with the writing to file.
		return false;
	}
	
	private void addPlayer(Player player)
	{
		//Run a loop through players array and if its empty, add the player to the array
		for(int i = 0; i < players.length; i++)
		{
			if(players[i] == null)
			{
				players[i] = player;
			}
		}
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	private int maxMoves(int input)
	{
		int player1Input = 0;
		int player2Input = 0;
		
		//renderMaxMovesGUI
		//take input from player1 and validate
		
		//renderMaxMovesGUI
		//take input from player2 and validate
		
		//RUN BOTH IN LOOPS WHILE VALIDATING
		
		return (player1Input + player2Input) / 2;
	}
	
	private void renderMaxMovesGUI()
	{
		//Render a new MaxMovesGUI.java class.
		
		
	}
	
	public void renderBoardGUI()
	{
		setPieces();
	}
	
	public void startGame()
	{
		//IN A LOOP,
		//Render board GUI and check player turns,
		//Once player moves, run the move/isValid commands
		//once game is over,
		//run writeDataToFile()
		renderBoardGUI();
	}
	
	private boolean getPlayerTurn()
	{
		return playerTurn;
	}
	
	public void move()
	{
		
	}
	
	private void isValid()
	{
		
	}
	
	public void endGame()
	{
		
	}
	
	private void writeDataToFile()
	{
		
	}

	public Piece[] getPieces() {
		return pieces;
	}

	public void setPieces() {
		pieces = new Piece[12];
		pieces[0] = new Bishop(0,0,"blackBishop");
		pieces[1] = new Bishop(0,1,"blackRook");
		pieces[2] = new Bishop(0,2,"blackKnight");
		pieces[3] = new Bishop(0,3,"blackKnight");
		pieces[4] = new Bishop(0,4,"blackRook");
		pieces[5] = new Bishop(0,5,"blackBishop");
		pieces[6] = new Bishop(5,0,"whiteBishop");
		pieces[7] = new Bishop(5,1,"whiteRook");
		pieces[8] = new Bishop(5,2,"whiteKnight");
		pieces[9] = new Bishop(5,3,"whiteKnight");
		pieces[10] = new Bishop(5,4,"whiteRook");
		pieces[11] = new Bishop(5,5,"whiteBishop");
	}

	public int getMaxMoves() {
		return maxMoves;
	}

	public void setMaxMoves(int maxMoves) {
		this.maxMoves = maxMoves;
	}	
}