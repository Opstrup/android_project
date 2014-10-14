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
}
