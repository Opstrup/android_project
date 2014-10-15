package com.example.tictactoe.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class TerminatorBot implements IBot
{
	BoardFieldEnum _playerType;
	BoardFieldEnum _player;
	
	public TerminatorBot(BoardFieldEnum playerType)
	{
		_playerType = playerType;
		_player = playerType;
	}
	
	/*
	 * 
	 * best_score[0] = score
	 * best_score[1] = position
	 */
	@Override
	public int move(IBoard theBoard) {
		
		int[] best_score = {0, 0};
		
		if (theBoard.WhoWon() == BoardFieldEnum.PLAYER_O)
		{
			best_score[0] = -1;
			best_score[1] = -1;
			return best_score[1];
//			return (-1, (-1, -1))
		}
		
		if (theBoard.WhoWon() == BoardFieldEnum.PLAYER_X)
		{
			best_score[0] = 1;
			best_score[1] = -1;
			return best_score[1];
//		    return (1, (-1, -1))
		}
		
		    best_score[0] = 0;
		    best_score[1] = -1;
		    List<Object> moves = new ArrayList<Object>();
		    List<Integer> score = new ArrayList<Integer>();
		    		    
		    for (Integer empty_field : theBoard.GetEmptySquares()) 
		    {
		    	IBoard copy_board = theBoard.Clone();
		    	copy_board.UpdateBoard(_player, empty_field);
		    	if (_player == _playerType) 
		    		_player = BoardFieldEnum.PLAYER_X;
		    	
		    	score.add(move(copy_board));
		    	
		    	//Winning move
		    	if (score.get(0) * 1 == 1) 
					return score.get(0);
		    	
		    	moves.add(empty_field);
		    	
		    	for (int i = 0; i < score.size(); i++) 
		    	{
					if (_player == BoardFieldEnum.PLAYER_X && best_score[0] <= (int) score.get(i))
					{
						best_score[1] = (Integer) moves.get(i);
					}
					
					if (_player == BoardFieldEnum.PLAYER_O && best_score[0] >= (int) score.get(i))
					{
						best_score[1] = (Integer) moves.get(i);
					}
				}
			}
		    
		    return best_score[1];
//		    for empty_field in board.get_empty_squares():
//		        copy_board = board.clone()
//		        copy_board.move(empty_field[0], empty_field[1], player)
//		        score.append(mm_move(copy_board, provided.switch_player(player))[0])
//
//		        # Winning move
//		        if score[0] * SCORES[player] is 1:
//		            return (score[0], tuple(empty_field))
//
//		        moves.append(empty_field)
//
//		        for index in range(len(score)):
//		            if player is provided.PLAYERX:
//		                if best_score[0] <= score[index]:
//		                    best_score = (score[index], (moves[index]))
//		            elif player is provided.PLAYERO:
//		                if best_score[0] >= score[index]:
//		                    best_score =  (score[index], (moves[index]))
//
//		    return best_score
	}

	@Override
	public BoardFieldEnum getPlayerType() 
	{
		return _playerType;
	}

}
