package com.example.tictactoe.GameLogic;

public class RandomBot implements IBot 
{
	BoardFieldEnum _playerType;
	
	public RandomBot (BoardFieldEnum playerType)
	{
		_playerType = playerType;
	}
	
	@Override
	public int move(IBoard theBoard) 
	{
		
		int gridSize = 8;
		int gridMin = 0;
		int locationOnBoard = (int )(Math.random() * gridSize + gridMin);
		
		while ((theBoard.UpdateBoard(_playerType, locationOnBoard)) == false)
		{
			locationOnBoard = (int )(Math.random() * gridSize + gridMin);
		}
		
		return locationOnBoard;
	}

	@Override
	public BoardFieldEnum getPlayerType() 
	{
		return _playerType;
	}

}
