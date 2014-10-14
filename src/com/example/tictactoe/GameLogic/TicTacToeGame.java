package com.example.tictactoe.GameLogic;

public class TicTacToeGame implements ITicTacToeGame 
{
	IBot _theBot;
	IBoard _theBoard;
	int _botScore = 0;
	int _playerScore = 0;
	int _rounds = 0;
	BoardFieldEnum _player;
	
	/*
	 * Constructor for TicTacToeGame
	 * Set boardSize, botType
	 */
	public TicTacToeGame(int boardSize, IBot botType, BoardFieldEnum player) 
	{
		_theBoard = new Board(boardSize);
		_player = player;
		_theBot = botType;
	}
	
	@Override
	public int getBotScore()
	{
		return _botScore;
	}
	
	@Override
	public int getPlayerScore()
	{
		return _playerScore;
	}
	
	@Override
	public int getRounds()
	{
		return _rounds;
	}
	
	@Override
	public void newGame()
	{
		_theBoard.CleanBoard();
	}

	@Override
	public BoardFieldEnum WhoWon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int moveBot() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changeTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardFieldEnum whosTurn() {
		// TODO Auto-generated method stub
		return null;
	}
}
