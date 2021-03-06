package com.example.tictactoe.GameLogic;

public interface ITicTacToeGame 
{
	BoardFieldEnum WhoWon();
	int getBotScore();
	int getPlayerScore();
	int getRounds();
	void newGame();
	int moveBot();
	void changeTurn();
	BoardFieldEnum whosTurn();
	Boolean HasWinner();
	Boolean BoardIsFull();
	Boolean UpdateBoard(int locationOnBoard);
	BoardFieldEnum getPlayerType();
	void updateScore();
	void setBoard(IBoard board);
}
