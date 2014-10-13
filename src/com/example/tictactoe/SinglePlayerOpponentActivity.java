package com.example.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SinglePlayerOpponentActivity extends Activity 
{
	public final static String GameType_Message = "com.example.tictactoe.MESSAGE1";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_opponent);
        
        Intent intent = getIntent();
    }
	
	public void StartRandomGame(View view) {
    	Intent RandomGame_intent = new Intent(this, SinglePlayerGameActivity.class);
    	RandomGame_intent.putExtra(GameType_Message, "1");
    	startActivity(RandomGame_intent);
    }
	
	public void StartTerminatorGame(View view) {
    	Intent TerminatorGame_intent = new Intent(this, SinglePlayerGameActivity.class);
    	TerminatorGame_intent.putExtra(GameType_Message, 2);
    	startActivity(TerminatorGame_intent);
    }
}
