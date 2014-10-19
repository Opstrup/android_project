package com.example.tictactoe.GameLogic;

public class TicTacToeGame implements ITicTacToeGame 
{
	IBot _theBot;
	IBoard _theBoard;
	int _botScore = 0;
	int _playerScore = 0;
	int _rounds = 0;
	BoardFieldEnum _player;
	BoardFieldEnum _whosTurn;
	
	/*
	 * Constructor for TicTacToeGame
	 * Set boardSize, botType
	 */
	public TicTacToeGame(int boardSize, IBot botType, BoardFieldEnum player) 
	{
		_theBoard = new Board(boardSize);
		_player = player;
		_theBot = botType;
		_whosTurn = BoardFieldEnum.PLAYER_X;
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
	public BoardFieldEnum WhoWon() 
	{
		return _theBoard.WhoWon();
	}

	@Override
	public int moveBot() 
	{
		return _theBot.move(_theBoard);
	}

	@Override
	public void changeTurn() 
	{
		if (_whosTurn == BoardFieldEnum.PLAYER_O)
			_whosTurn = BoardFieldEnum.PLAYER_X;
	}

	@Override
	public BoardFieldEnum whosTurn() 
	{
		return _whosTurn;
	}

	@Override
	public Boolean HasWinner() 
	{
		return _theBoard.HasWinner();
	}

	@Override
	public Boolean BoardIsFull() 
	{
		return _theBoard.BoardIsFull();
	}

	@Override
	public Boolean UpdateBoard(int locationOnBoard) 
	{
		return _theBoard.UpdateBoard(_player, locationOnBoard);
	}

	@Override
	public BoardFieldEnum getPlayerType() 
	{
		return _player;
	}

	@Override
	public void updateScore() 
	{
		if (_theBoard.WhoWon() == _theBot.getPlayerType()) 
			_botScore++;
		else if (_theBoard.WhoWon() == _player)
			_playerScore++;	
	}
}
