package com.example.tictactoe;

import com.example.tictactoe.GameLogic.BoardFieldEnum;
import com.example.tictactoe.GameLogic.IBot;
import com.example.tictactoe.GameLogic.ITicTacToeGame;
import com.example.tictactoe.GameLogic.RandomBot;
import com.example.tictactoe.GameLogic.TicTacToeGame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglePlayerGameActivity extends Activity 
{
    ITicTacToeGame theGame;
    IBot theBot;
    int Tic_or_Toe;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_game);
        
        Intent gameIntent = getIntent();
        
        String msg = gameIntent.getStringExtra(SinglePlayerOpponentActivity.GameType_Message);
        int gameTypeNumber = gameIntent.getIntExtra(SinglePlayerOpponentActivity.GameType_Message,1);
        TextView opponentText = (TextView) findViewById(R.id.gameType2);
        
        if(gameTypeNumber == 1)
        {
        	theBot = new RandomBot(BoardFieldEnum.PLAYER_X);
        	theGame = new TicTacToeGame(9, theBot, BoardFieldEnum.PLAYER_O);
        	opponentText.setText("Random opponent");
        }
        else
        {
        	
        	opponentText.setText("Terminator Opponent");
        }
    }
	
	public void GameLoop()
	{
//		while (theGame.HasWinner() == false && theGame.BoardIsFull == false) 
//		{
//			while(PlayerMove == false);
//			
//			
//		}
	}
	
	public void SetButton(View view) 
	{
		
		if (theGame.whosTurn() == BoardFieldEnum.PLAYER_O)
		{
			Tic_or_Toe = R.drawable.bolle;
		}
		else
		{
			Tic_or_Toe = R.drawable.kryds;
		}
				
		switch (view.getId()) {
		case R.id.ImageButton00:
			ImageButton image00 = (ImageButton) findViewById(R.id.ImageButton00);
//			if( theGame.updateBoard(0) == True) 
//			{ 
//				image00.setImageResource(Tic_or_Toe);
//				
//			}
		

			break;
			
		case R.id.ImageButton01:
			ImageButton image01 = (ImageButton) findViewById(R.id.ImageButton01);
			image01.setImageResource(R.drawable.kryds);
			break;
		
			

		default:
			break;
		}
		
    }
}
