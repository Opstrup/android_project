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
		//Horizontal check
		if (CheckWinnerStraightlines(1)) 
			return true;
		
		//Vertical check
		if (CheckWinnerStraightlines(3))
			return true;
		
		//Diagonal check (0-8)		
		if (CheckWinnerDiagonalLines(0, 4))
			return true;
		
		//Diagonal check (2-6)
		if (CheckWinnerDiagonalLines(2, 2))
			return true;
		
		return false;
	}
	
	/*
	 * Helper function:
	 * Check the straight lines on the board for a win.
	 */
	private Boolean CheckWinnerStraightlines(int offset)
	{
		int index = 0;		
		{
			if (_board.get(index).toString() == _board.get(index+offset).toString() &&
				_board.get(index).toString() == _board.get(index+offset+offset).toString() &&
				_board.get(index).toString() != "EMPTY") 
			{
				return true;
			}
			index += 3;
		}
		return false;
	}
	
	/*
	 * Helper function:
	 * Check the diagonal lines on the board for a win.
	 */
	private Boolean CheckWinnerDiagonalLines(int index, int offset)
	{
		if (_board.get(index).toString() == _board.get(index+offset).toString() &&
			_board.get(index).toString() == _board.get(index+offset+offset).toString() &&
			_board.get(index).toString() != "EMPTY") 
			{
				return true;
			}
		return false;
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
			return false;
		}
		
		return true;
	}

}
