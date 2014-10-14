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
	
	/*
	 * Checks if there is a winner on the board
	 * returns true if there is a winner.
	 */
	@Override
	public Boolean HasWinner() 
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
	
	/*
	 * Clean Board
	 * Returns the board to initial state
	 * all locations on the board is empty
	 */
	@Override
	public void CleanBoard() 
	{
		int boardSize = _board.size();
		_board = null;
		
		_board = new ArrayList<BoardFieldEnum>();
		
		for (int i = 0; i < boardSize; i++) 
		{
			_board.add(BoardFieldEnum.EMPTY);
		}
		
	}

	/*
	 * WhoWon:
	 * If there is a winner on the board, 
	 * checks who is the winner. 
	 */
	@Override
	public BoardFieldEnum WhoWon() 
	{
		if (this.HasWinner() == true) 
		{
			if (CheckWhoWonStraightLines(1, BoardFieldEnum.PLAYER_O) || 
				CheckWhoWonStraightLines(3, BoardFieldEnum.PLAYER_O) ||
				CheckWhoWonDiagonalLines(0, 4, BoardFieldEnum.PLAYER_O) || 
				CheckWhoWonDiagonalLines(2, 2, BoardFieldEnum.PLAYER_O)) 
			{
				return BoardFieldEnum.PLAYER_O;
			}
			return BoardFieldEnum.PLAYER_X;
		}
		return null;
	}
	
	/*
	 * Helper function:
	 * Checks straight lines for who won.
	 */
	private Boolean CheckWhoWonStraightLines(int offset, BoardFieldEnum player)
	{
		int index = 0;
		if (_board.get(index).toString() == _board.get(index+offset).toString() &&
				_board.get(index).toString() == _board.get(index+offset+offset).toString() &&
				_board.get(index).toString() == player.toString()) 
				{
					return true;
				}
		return false;
	}
	
	/*
	 * Helper function:
	 * Checks diagonal lines for who won.
	 */
	private Boolean CheckWhoWonDiagonalLines(int index, int offset, BoardFieldEnum player)
	{
		if (_board.get(index).toString() == _board.get(index+offset).toString() &&
			_board.get(index).toString() == _board.get(index+offset+offset).toString() &&
			_board.get(index).toString() != player.toString()) 
			{
				return true;
			}
		return false;
	}

}
