package view;

public class GameEngineGUI {
	BoardGUI boardGUI;
	LoginRegisterGUI loginRegisterGUI;
	
	public GameEngineGUI()
	{
		
	}
	
	public void renderLoginRegister(String player)
	{
		loginRegisterGUI = new LoginRegisterGUI(player);
		loginRegisterGUI.renderGUI();
	}

	public void renderBoard()
	{
		boardGUI = new BoardGUI();
	}
}
