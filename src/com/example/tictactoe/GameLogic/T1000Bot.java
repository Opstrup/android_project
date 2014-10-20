package com.example.tictactoe.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class T1000Bot implements IBot
{
	BoardFieldEnum _player;
	
	public T1000Bot(BoardFieldEnum playerType)
	{
		_player = playerType;
	}
	
	@Override
	public int move(IBoard theBoard) 
	{
		IBoard _board;
		_board = theBoard;
		int move = 0;
		if (CheckIfOpponentHasTwoInLine(_board)) 
		{
			List<Integer> opponentLocations = findPlayer(BoardFieldEnum.PLAYER_X, _board);
			if (CheckHorizontalLines(1, BoardFieldEnum.PLAYER_X, _board)) 
			{
				if (opponentLocations.get(1) <= 2) 
				{
					if (_board.UpdateBoard(_player, 0)) 
					{	
						return 0;
					} else if (_board.UpdateBoard(_player, 1)) 
					{
						return 1;
					} else if (_board.UpdateBoard(_player, 2)) 
					{
						return 2;
					}
				}
				if (opponentLocations.get(1) <= 5) 
				{
					if (_board.UpdateBoard(_player, 3)) 
					{	
						return 3;
					} else if (_board.UpdateBoard(_player, 4)) 
					{
						return 4;
					} else if (_board.UpdateBoard(_player, 5)) 
					{
						return 5;
					}
				}
				if (opponentLocations.get(1) <= 8) 
				{
					if (_board.UpdateBoard(_player, 6)) 
					{	
						return 6;
					} else if (_board.UpdateBoard(_player, 7)) 
					{
						return 7;
					} else if (_board.UpdateBoard(_player, 8)) 
					{
						return 8;
					}
				}
			}
			if (CheckVerticalLines(3, BoardFieldEnum.PLAYER_X, _board)) 
			{
				if (opponentLocations.get(1) == 0 || opponentLocations.get(1) == 3 || opponentLocations.get(1) == 6) 
				{
					if (_board.UpdateBoard(_player, 0)) 
					{	
						return 0;
					} else if (_board.UpdateBoard(_player, 3)) 
					{
						return 3;
					} else if (_board.UpdateBoard(_player, 6)) 
					{
						return 6;
					}
				}
				if (opponentLocations.get(1) == 1 || opponentLocations.get(1) == 4 || opponentLocations.get(1) == 7) 
				{
					if (_board.UpdateBoard(_player, 1)) 
					{	
						return 1;
					} else if (_board.UpdateBoard(_player, 4)) 
					{
						return 4;
					} else if (_board.UpdateBoard(_player, 7)) 
					{
						return 7;
					}
				}
				if (opponentLocations.get(1) == 2 || opponentLocations.get(1) == 5 || opponentLocations.get(1) == 8) 
				{
					if (_board.UpdateBoard(_player, 2)) 
					{	
						return 2;
					} else if (_board.UpdateBoard(_player, 5)) 
					{
						return 5;
					} else if (_board.UpdateBoard(_player, 8)) 
					{
						return 8;
					}
				}
			}
			if (CheckDiagonalLines(0, 4, BoardFieldEnum.PLAYER_X, _board)) 
			{
				if (_board.UpdateBoard(_player, 4)) 
				{	
					return 4;
				} else if (_board.UpdateBoard(_player, 0)) 
				{
					return 0;
				} else if (_board.UpdateBoard(_player, 8)) 
				{
					return 8;
				}
			}
			if (CheckDiagonalLines(2, 2, BoardFieldEnum.PLAYER_X, _board)) 
			{
				if (_board.UpdateBoard(_player, 4)) 
				{	
					return 4;
				} else if (_board.UpdateBoard(_player, 2)) 
				{
					return 2;
				} else if (_board.UpdateBoard(_player, 6)) 
				{
					return 6;
				}
			}
		}
		else if (CheckIfSelfHasTwoInLine(_board)) 
		{
			List<Integer> selfLocations = findPlayer(BoardFieldEnum.PLAYER_O, _board);
			if (CheckHorizontalLines(1, BoardFieldEnum.PLAYER_O, _board)) 
			{
				if (selfLocations.get(1) <= 2) 
				{
					if (_board.UpdateBoard(_player, 0)) 
					{	
						return 0;
					} else if (_board.UpdateBoard(_player, 1)) 
					{
						return 1;
					} else if (_board.UpdateBoard(_player, 2)) 
					{
						return 2;
					}
				}
				if (selfLocations.get(1) <= 5) 
				{
					if (_board.UpdateBoard(_player, 3)) 
					{	
						return 3;
					} else if (_board.UpdateBoard(_player, 4)) 
					{
						return 4;
					} else if (_board.UpdateBoard(_player, 5)) 
					{
						return 5;
					}
				}
				if (selfLocations.get(1) <= 8) 
				{
					if (_board.UpdateBoard(_player, 6)) 
					{	
						return 6;
					} else if (_board.UpdateBoard(_player, 7)) 
					{
						return 7;
					} else if (_board.UpdateBoard(_player, 8)) 
					{
						return 8;
					}
				}
			}
			if (CheckVerticalLines(3, BoardFieldEnum.PLAYER_O, _board)) 
			{
				if (selfLocations.get(1) == 0 || selfLocations.get(1) == 3 || selfLocations.get(1) == 6) 
				{
					if (_board.UpdateBoard(_player, 0)) 
					{	
						return 0;
					} else if (_board.UpdateBoard(_player, 3)) 
					{
						return 3;
					} else if (_board.UpdateBoard(_player, 6)) 
					{
						return 6;
					}
				}
				if (selfLocations.get(1) == 1 || selfLocations.get(1) == 4 || selfLocations.get(1) == 7) 
				{
					if (_board.UpdateBoard(_player, 1)) 
					{	
						return 1;
					} else if (_board.UpdateBoard(_player, 4)) 
					{
						return 4;
					} else if (_board.UpdateBoard(_player, 7)) 
					{
						return 7;
					}
				}
				if (selfLocations.get(1) == 2 || selfLocations.get(1) == 5 || selfLocations.get(1) == 8) 
				{
					if (_board.UpdateBoard(_player, 2)) 
					{	
						return 2;
					} else if (_board.UpdateBoard(_player, 5)) 
					{
						return 5;
					} else if (_board.UpdateBoard(_player, 8)) 
					{
						return 8;
					}
				}
			}
			if (CheckDiagonalLines(0, 4, BoardFieldEnum.PLAYER_O, _board)) 
			{
				if (_board.UpdateBoard(_player, 4)) 
				{	
					return 4;
				} else if (_board.UpdateBoard(_player, 0)) 
				{
					return 0;
				} else if (_board.UpdateBoard(_player, 8)) 
				{
					return 8;
				}
			}
			if (CheckDiagonalLines(2, 2, BoardFieldEnum.PLAYER_O, _board)) 
			{
				if (_board.UpdateBoard(_player, 4)) 
				{	
					return 4;
				} else if (_board.UpdateBoard(_player, 2)) 
				{
					return 2;
				} else if (_board.UpdateBoard(_player, 6)) 
				{
					return 6;
				}
			}
		}
		else
		{
			int gridSize = 8;
			int gridMin = 0;
			int locationOnBoard = (int )(Math.random() * gridSize + gridMin);
			
			while ((theBoard.UpdateBoard(_player, locationOnBoard)) == false)
			{
				locationOnBoard = (int )(Math.random() * gridSize + gridMin);
			}
			
			move = locationOnBoard;
		}
		
		return move;
	}

	@Override
	public BoardFieldEnum getPlayerType() 
	{
		return _player;
	}
	
	private List<Integer> findPlayer(BoardFieldEnum player, IBoard board)
	{
		List<Integer> playerLocation = new ArrayList<Integer>();
		
		for (int i = 0; i < board.getBoard().size(); i++) 
		{
			if (board.getBoard().get(i) == player) 
			{
				playerLocation.add(i);
			}
		}
		
		return playerLocation;
	}
	
	private Boolean CheckIfOpponentHasTwoInLine(IBoard board)
	{
		if(CheckHorizontalLines(1, BoardFieldEnum.PLAYER_X, board) ||
		   CheckVerticalLines(3, BoardFieldEnum.PLAYER_X, board) ||
	   	   CheckDiagonalLines(0, 4, BoardFieldEnum.PLAYER_X, board) ||
		   CheckDiagonalLines(2, 2, BoardFieldEnum.PLAYER_X, board))
		{
			return true;
		}
		
		return false;
	}
	
	private Boolean CheckIfSelfHasTwoInLine(IBoard board)
	{
		if(CheckHorizontalLines(1, BoardFieldEnum.PLAYER_O, board) ||
		   CheckVerticalLines(3, BoardFieldEnum.PLAYER_O, board) ||
	   	   CheckDiagonalLines(0, 4, BoardFieldEnum.PLAYER_O, board) ||
		   CheckDiagonalLines(2, 2, BoardFieldEnum.PLAYER_O, board))
		{
			return true;
		}
		
		return false;
	}
	
	/*
	 * Helper function:
	 * Checks straight lines for two on same line.
	 */
	private Boolean CheckHorizontalLines(int offset, BoardFieldEnum player, IBoard board)
	{
		int index = 0;
		while(index <= 6) {
		if (board.getBoard().get(index) == board.getBoard().get(index+offset) ||
			board.getBoard().get(index) == board.getBoard().get(index+offset+offset) ||
			board.getBoard().get(index+offset) == board.getBoard().get(index+offset+offset))
			if (board.getBoard().get(index).toString() == player.toString() && board.getBoard().get(index+offset).toString() == player.toString() ||
				board.getBoard().get(index).toString() == player.toString() && board.getBoard().get(index+offset+offset).toString() == player.toString() ||
				board.getBoard().get(index+offset).toString() == player.toString() && board.getBoard().get(index+offset+offset).toString() == player.toString()) 
			{
				return true;
			}
			index += 3;
		}
		return false;
	}
		
	private Boolean CheckVerticalLines(int offset, BoardFieldEnum player, IBoard board)
	{
		int index = 0;		
		while(index <= 2) {

		if (board.getBoard().get(index).toString() == board.getBoard().get(index+offset).toString() ||
			board.getBoard().get(index).toString() == board.getBoard().get(index+offset+offset).toString() ||
			board.getBoard().get(index+offset).toString() == board.getBoard().get(index+offset+offset).toString())
			if (board.getBoard().get(index).toString() == player.toString() && board.getBoard().get(index+offset).toString() == player.toString() ||
				board.getBoard().get(index).toString() == player.toString() && board.getBoard().get(index+offset+offset).toString() == player.toString() ||
				board.getBoard().get(index+offset).toString() == player.toString() && board.getBoard().get(index+offset+offset).toString() == player.toString()) 
			{
				return true;
			}
			index ++;
		}
		return false;
	}
	
	/*
	 * Helper function:
	 * Checks diagonal lines for who won.
	 */
	private Boolean CheckDiagonalLines(int index, int offset, BoardFieldEnum player, IBoard board)
	{
		if (board.getBoard().get(index).toString() == board.getBoard().get(index+offset).toString() ||
			board.getBoard().get(index).toString() == board.getBoard().get(index+offset+offset).toString() ||
			board.getBoard().get(index+offset).toString() == board.getBoard().get(index+offset+offset).toString())
			if (board.getBoard().get(index).toString() == player.toString() && board.getBoard().get(index+offset).toString() == player.toString() ||
				board.getBoard().get(index).toString() == player.toString() && board.getBoard().get(index+offset+offset).toString() == player.toString() ||
				board.getBoard().get(index+offset).toString() == player.toString() && board.getBoard().get(index+offset+offset).toString() == player.toString()) 
			{
				return true;
			}
		return false;
	}

}
