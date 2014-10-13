package com.example.tictactoe.GameLogic;

public class TicTacToeGame 
{
	IBot _theBot;
	IBoard _theBoard;
	BotTypeEnum _botType;
	
	public TicTacToeGame(int boardSize, BotTypeEnum botTypeEnum) 
	{
		_theBoard = new Board();
	}
	
	
	void startGame()
	{
		// Start game here with all the logic
	}
}
