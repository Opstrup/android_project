package com.example.tictactoe.GameLogic;

public interface IBoard 
{
	Boolean hasWinner();
	void UpdateBoard(int player, int locationOnBoard);
	Boolean BoardIsFull();
}
