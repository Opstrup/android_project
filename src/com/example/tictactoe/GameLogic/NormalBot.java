package com.example.tictactoe.GameLogic;

public class NormalBot implements IBot {
	BoardFieldEnum _playerType;

	public NormalBot(BoardFieldEnum playerType) {
		_playerType = playerType;
	}

	@Override
	public int move(IBoard theBoard) {

		int gridSize = 8;
		int gridMin = 0;
		int locationOnBoard;

		for (int i = 0; i <= gridSize; i++) 
		{
			if(theBoard.UpdateBoard(_playerType, i)) 
			{
//				char curr = i;
//				mBoard[i] = ANDROID_PLAYER;
//				if (checkForWinner() == 3) {
//					setMove(ANDROID_PLAYER, i);
//					return i;
//				} else
//					mBoard[i] = curr;
			}
		}

		locationOnBoard = (int) (Math.random() * gridSize + gridMin);

		while ((theBoard.UpdateBoard(_playerType, locationOnBoard)) == false) {
			locationOnBoard = (int) (Math.random() * gridSize + gridMin);
		}

		return locationOnBoard;
	}

	@Override
	public BoardFieldEnum getPlayerType() {
		return _playerType;
	}

}