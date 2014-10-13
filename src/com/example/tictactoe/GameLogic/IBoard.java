package com.example.tictactoe.GameLogic;

public interface IBoard 
{
	Boolean hasWinner();
	Boolean UpdateBoard(BoardFieldEnum player, int locationOnBoard);
	Boolean BoardIsFull();
}
