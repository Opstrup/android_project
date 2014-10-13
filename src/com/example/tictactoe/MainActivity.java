package com.example.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void StartSinglePlayer(View view) {
    	Intent SinglePlayerOpponent_intent = new Intent(this, SinglePlayerOpponentActivity.class);
    	startActivity(SinglePlayerOpponent_intent);
    }

}
