package com.example.tictactoe;

import com.example.tictactoe.GameLogic.BoardFieldEnum;
import com.example.tictactoe.GameLogic.IBot;
import com.example.tictactoe.GameLogic.ITicTacToeGame;
import com.example.tictactoe.GameLogic.RandomBot;
import com.example.tictactoe.GameLogic.TicTacToeGame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SinglePlayerGameActivity extends Activity 
{
    ITicTacToeGame theGame;
    IBot theBot;
    int Tic_or_Toe, move;
    boolean PlayerMove = true;
    ImageButton image;
    int imagearray[] = {R.id.ImageButton00,R.id.ImageButton01,R.id.ImageButton02,R.id.ImageButton03,R.id.ImageButton04,R.id.ImageButton05,R.id.ImageButton06,R.id.ImageButton07,R.id.ImageButton08};
    
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
	
	
	
	public void SetButton(View view) 
	{
		
//		if (theGame.whosTurn() == theGame.getPlayerType())
//		{
//			Tic_or_Toe = R.drawable.bolle;
//		}
//		else
//		{
//			Tic_or_Toe = R.drawable.kryds;
//		}
				
		switch (view.getId()) {
		case R.id.ImageButton00:
			image = (ImageButton) findViewById(R.id.ImageButton00);
			if( theGame.UpdateBoard(0) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
								
			}
			break;
			
		case R.id.ImageButton01:
			image = (ImageButton) findViewById(R.id.ImageButton01);
			if( theGame.UpdateBoard(1) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
				
			}
			break;
		
		case R.id.ImageButton02:
			image = (ImageButton) findViewById(R.id.ImageButton02);
			if( theGame.UpdateBoard(2) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
							
			}
			break;
		
		case R.id.ImageButton03:
			image = (ImageButton) findViewById(R.id.ImageButton03);
			if( theGame.UpdateBoard(3) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
						
			}
			break;
			
		case R.id.ImageButton04:
			image = (ImageButton) findViewById(R.id.ImageButton04);
			if( theGame.UpdateBoard(4) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
								
			}
			break;
			
		case R.id.ImageButton05:
			image = (ImageButton) findViewById(R.id.ImageButton05);
			if( theGame.UpdateBoard(5) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
								
			}
			break;
			
		case R.id.ImageButton06:
			image = (ImageButton) findViewById(R.id.ImageButton06);
			if( theGame.UpdateBoard(6) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);			
			}
			break;
			
		case R.id.ImageButton07:
			image = (ImageButton) findViewById(R.id.ImageButton07);
			if( theGame.UpdateBoard(7) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);
								
			}
			break;
			
		case R.id.ImageButton08:
			image = (ImageButton) findViewById(R.id.ImageButton08);
			if( theGame.UpdateBoard(8) == true) 
			{ 
				image.setImageResource(Tic_or_Toe);				
			}
			break;

		default:
			break;
		}
		
		//Check for winner or Draw
		if(theGame.HasWinner()== true || theGame.BoardIsFull() == true)
		{
			if (theGame.WhoWon() == BoardFieldEnum.PLAYER_O)
			{
			Context context = getApplicationContext();
			CharSequence text = "Pladen er fuld / der er fundes en vinder";
			int duration = Toast.LENGTH_LONG;
			
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			
			theGame.newGame();
			
			}
			else
			{
				Context context = getApplicationContext();
				CharSequence text = "Pladen er fuld / der er fundes en vinder";
				int duration = Toast.LENGTH_LONG;
				
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
		}
		
		theGame.changeTurn();
		
		//move = theGame.moveBot();
		//String moveString = ("ImageButton0" + move);
		//image = (ImageButton) findViewById(R.id.ImageButton00);
		//int imageTag;
		
		image = (ImageButton) findViewById(imagearray[theGame.moveBot()]);
		
		image.setImageResource(R.drawable.bolle);	
		
		//Update GUI
		//Check for winner or Draw
		theGame.changeTurn();
    }
}
