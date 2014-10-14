package com.example.tictactoe.GameLogic;

public class TicTacToeGame 
{
	IBot _theBot;
	IBoard _theBoard;
	int _botScore = 0;
	int _playerScore = 0;
	int _rounds = 0;
	
	public TicTacToeGame(int boardSize, BotTypeEnum botTypeEnum, BoardFieldEnum playerType) 
	{
		_theBoard = new Board(boardSize);
		
		if (botTypeEnum.toString() == "RANDOMBOT")
		{
			_theBot = new RandomBot(playerType);
		}
		else if (botTypeEnum.toString() == "TERMINATOR") 
		{
			//create terminator bot
		}
	}
	
	public int getBotScore()
	{
		return _botScore;
	}
	
	public int getPlayerScore()
	{
		return _playerScore;
	}
	
	public int getRounds()
	{
		return _rounds;
	}
	
	
	void newGame()
	{
		// Start game here with all the logic
	}
}
