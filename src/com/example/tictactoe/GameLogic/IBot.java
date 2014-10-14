package com.example.tictactoe.GameLogic;
import com.example.tictactoe.GameLogic.IBoard;

public interface IBot 
{
	int move(IBoard theBoard);
	BoardFieldEnum getPlayerType();
}
