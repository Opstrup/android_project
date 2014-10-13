package com.example.tictactoe.GameLogic;

public class TicTacToeGame 
{
	IBot _theBot;
	IBoard _theBoard;
	
	public TicTacToeGame(int boardSize, BotTypeEnum botTypeEnum) 
	{
		_theBoard = new Board(boardSize);
		
		if (botTypeEnum.toString() == "RANDOMBOT")
		{
			_theBot = new RandomBot();
		}
	}
	
	
	void startGame()
	{
		// Start game here with all the logic
	}
}
