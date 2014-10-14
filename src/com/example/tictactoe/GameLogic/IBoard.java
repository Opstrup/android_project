package com.example.tictactoe.GameLogic;

public interface IBoard 
{
	Boolean HasWinner();
	Boolean UpdateBoard(BoardFieldEnum player, int locationOnBoard);
	Boolean BoardIsFull();
	void CleanBoard();
	BoardFieldEnum WhoWon();
}
