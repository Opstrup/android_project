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
        TextView opponentText = (TextView) findViewById(R.id.gameType2);
        
        if(gameTypeNumber == 1)
        {
        	
        	opponentText.setText("Random opponent");
        }
        else
        {
        	opponentText.setText("Terminator Opponent");
        }
    }
	
	
	public void Setpiece(View view) {
		
		ImageButton image1 = (ImageButton) findViewById(R.id.ImageButton05);
    	
		image1.setImageResource(R.drawable.kryds);
		
    }
}
