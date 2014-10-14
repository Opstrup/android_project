package com.example.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SinglePlayerGameActivity extends Activity 
{
    
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_game);
        
        Intent gameIntent = getIntent();
        
        String msg = gameIntent.getStringExtra(SinglePlayerOpponentActivity.GameType_Message);
        int gameTypeNumber = gameIntent.getIntExtra(SinglePlayerOpponentActivity.GameType_Message,1);
        //TextView opponentText = (TextView) findViewById(R.id.gameType2);
        
        if(gameTypeNumber == 1)
        {
        	
        //	opponentText.setText("Random opponent");
        }
        else
        {
        //	opponentText.setText("Terminator Opponent");
        }
    }
	
	
	public void SetButton(View view) {
		
		/*
		 ImageButton image00 = (ImageButton) findViewById(R.id.imageButton00);
		 
    	
		image00.setImageResource(R.drawable.kryds);
		*/
		
		
		switch (view.getId()) {
		case R.id.ImageButton00:
			ImageButton image00 = (ImageButton) findViewById(R.id.ImageButton00);
			image00.setImageResource(R.drawable.kryds);
			break;
			
		case R.id.ImageButton01:
			ImageButton image01 = (ImageButton) findViewById(R.id.ImageButton01);
			image01.setImageResource(R.drawable.kryds);
			break;
			
	
			
			/*
			 * Hvis tur er det?
			 * - kryds/bolle
			 * 		Hvis det er players tur:
			 * 			set drawable til kryds eller bolle
			 * 
			 * Er pladsen ikke taget?
			 * 
			 * 		set billede på position.
			 * 		void update.
			 * Hvis plads er taget:
			 * 		Ingen reaktion.
			 * 
			 */
			

		default:
			break;
		}
		
    }
}
