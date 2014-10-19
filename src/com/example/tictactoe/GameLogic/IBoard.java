package com.example.tictactoe.GameLogic;

import java.util.List;

public interface IBoard 
{
	Boolean HasWinner();
	Boolean UpdateBoard(BoardFieldEnum player, int locationOnBoard);
	Boolean BoardIsFull();
	void CleanBoard();
	BoardFieldEnum WhoWon();
	IBoard Clone();
	List<Integer> GetEmptySquares();
	List<?> getBoard();
}
