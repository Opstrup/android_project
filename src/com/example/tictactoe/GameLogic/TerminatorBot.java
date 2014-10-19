package com.example.tictactoe.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class TerminatorBot implements IBot
{
	BoardFieldEnum _player;
	
	public TerminatorBot(BoardFieldEnum playerType)
	{
		_player = playerType;
	}

	@Override
	public int move(IBoard theBoard) 
	{
		return calculateBestMove(theBoard, _player);
	}
	
	/*
	 * bot always plays as O
	 * best_score[0] = score
	 * best_score[1] = position
	 */
	private int calculateBestMove(IBoard theBoard, BoardFieldEnum player) 
	{
		int[] best_score = {0, 0};
		
		if (theBoard.WhoWon() == BoardFieldEnum.PLAYER_O)
		{
			best_score[0] = 1;
			best_score[1] = -1;
			return best_score[0];
		}
		
		if (theBoard.WhoWon() == BoardFieldEnum.PLAYER_X)
		{
			best_score[0] = -1;
			best_score[1] = -1;
			return best_score[0];
		}
		
		if (theBoard.WhoWon() == BoardFieldEnum.DRAW) 
		{
			best_score[0] = 0;
			best_score[1] = -1;
			return best_score[0];
		}
		
		    best_score[0] = 0;
		    best_score[1] = -1;
		    List<Object> moves = new ArrayList<Object>();
		    List<Integer> score = new ArrayList<Integer>();
		    		    
		    for (Integer empty_field : theBoard.GetEmptySquares()) 
		    {
		    	IBoard copy_board = theBoard.Clone();
		    	copy_board.UpdateBoard(_player, empty_field);
		    	BoardFieldEnum other_player;
				if (player == BoardFieldEnum.PLAYER_O) 
		    		other_player = BoardFieldEnum.PLAYER_X;
				else
					other_player = BoardFieldEnum.PLAYER_O;
		    	
		    	score.add(calculateBestMove(copy_board, other_player));
		    	
		    	//Winning move
		    	if (_player == BoardFieldEnum.PLAYER_O) 
		    	{
		    		if (score.get(0) * 1 == 1) 
						return empty_field;
				} 
		    	else if (_player == BoardFieldEnum.PLAYER_X) 
		    	{
		    		if (score.get(0) * 1 == -1) 
						return empty_field;
				}
		    	
		    	moves.add(empty_field);
		    	
		    	for (int i = 0; i < score.size(); i++) 
		    	{
					if (_player == BoardFieldEnum.PLAYER_X && best_score[0] >= (int) score.get(i))
					{
						best_score[1] = (Integer) moves.get(i);
					}
					
					if (_player == BoardFieldEnum.PLAYER_O && best_score[0] <= (int) score.get(i))
					{
						best_score[1] = (Integer) moves.get(i);
					}
				}
			}
		    
		return best_score[1];
	}

	@Override
	public BoardFieldEnum getPlayerType() 
	{
		return _player;
	}

}
