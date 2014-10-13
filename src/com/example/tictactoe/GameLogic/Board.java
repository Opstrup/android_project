package com.example.tictactoe.GameLogic;

import java.util.ArrayList;
import java.util.List;


public class Board implements IBoard
{
	List<BoardFieldEnum> _board;
	
	/*
	 * Constructor for Board:
	 * Creates a board with the desired board size.
	 */
	public Board(int boardSize)
	{
		_board = new ArrayList<BoardFieldEnum>();
		
		for (int i = 0; i < boardSize; i++) 
		{
			_board.add(BoardFieldEnum.EMPTY);
		}
	}	
	
	@Override
	public Boolean hasWinner() 
	{
		// Check vertical win
		for (int i = 0; i < 3; i++) 
		{
			int verticalLine = 0;

		}
		
		return null;
	}
	
	/*
	 * Update board function:
	 * Updates the board with the player move if legal move.
	 */
	@Override
	public Boolean UpdateBoard(BoardFieldEnum player, int locationOnBoard) 
	{
		if (locationOnBoard < _board.size()) 
		{
			if (_board.get(locationOnBoard).toString() == "EMPTY") 
			{
				_board.set(locationOnBoard, player);
				return true;
			}
			return false;
		}
		return false;
	}

	/*
	 * Check function for board.
	 * Returns true if board is full
	 * else false.
	 */
	@Override
	public Boolean BoardIsFull() 
	{
		boolean emptyFlag = false;
		
		for (BoardFieldEnum spotOnBoard : _board) 
		{
			if (spotOnBoard.toString() == "EMPTY") 
			{
				emptyFlag = true;
			}
		}
		
		if (emptyFlag == true) 
		{
			return true;
		}
		
		return false;
	}

}
