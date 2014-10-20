package com.example.tictactoe;

import com.example.tictactoe.GameLogic.BoardFieldEnum;
import com.example.tictactoe.GameLogic.IBot;
import com.example.tictactoe.GameLogic.ITicTacToeGame;
import com.example.tictactoe.GameLogic.NormalBot;
import com.example.tictactoe.GameLogic.RandomBot;
import com.example.tictactoe.GameLogic.TicTacToeGame;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SinglePlayerGameActivity extends Activity {
	ITicTacToeGame theGame;
	IBot theBot;
	int Tic_or_Toe, move;
	boolean PlayerMove = true;
	ImageButton image;
	int imagearray[] = { R.id.ImageButton00, R.id.ImageButton01,
			R.id.ImageButton02, R.id.ImageButton03, R.id.ImageButton04,
			R.id.ImageButton05, R.id.ImageButton06, R.id.ImageButton07,
			R.id.ImageButton08 };
	boolean correctMove = false;
	boolean playerStarted = true;
	Intent gameIntent;
	
	
	//used for register alarm manager
    PendingIntent pendingIntent;
    //used to store running alarmmanager instance
    AlarmManager alarmManager;
    //Callback function for Alarmmanager event
    BroadcastReceiver mReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		RegisterAlarmBroadcast();
		
		setContentView(R.layout.activity_single_player_game);
		gameIntent = getIntent();

		String msg = gameIntent.getStringExtra(SinglePlayerOpponentActivity.GameType_Message);
		int gameTypeNumber = gameIntent.getIntExtra(
				SinglePlayerOpponentActivity.GameType_Message, 1);
		TextView opponentText = (TextView) findViewById(R.id.gameType2);

		if (gameTypeNumber == 1) 
		{
			theBot = new RandomBot(BoardFieldEnum.PLAYER_O);
			theGame = new TicTacToeGame(9, theBot, BoardFieldEnum.PLAYER_X);
			opponentText.setText("Random opponent");
		} 
		else 
		{
			theBot = new NormalBot(BoardFieldEnum.PLAYER_O);
			theGame = new TicTacToeGame(9, theBot, BoardFieldEnum.PLAYER_X);
			opponentText.setText("Terminator Opponent");
		}
		
		if (savedInstanceState != null) {
			onRestoreInstanceState(savedInstanceState);
		}
	}
	
	

	private void RegisterAlarmBroadcast() {
		mReceiver = new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent)
            {
            	NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            	PendingIntent pIntent = PendingIntent.getActivity(SinglePlayerGameActivity.this, 0, gameIntent, 0);
            	
            	Notification notification  = new Notification.Builder(SinglePlayerGameActivity.this)
                		.setContentTitle("TicTacToe")
        		        .setContentText("Continue the game")
        		        .setSmallIcon(R.drawable.kryds)
        		        .setContentIntent(pIntent)
        		        .setAutoCancel(true)
        		        .build();

				notificationManager.notify(0,notification);                
            }

        };
		
        registerReceiver(mReceiver, new IntentFilter("com.example.tictactoe") );
        pendingIntent = PendingIntent.getBroadcast( this, 0, new Intent("com.example.tictactoe"),0 );
        alarmManager = (AlarmManager)(this.getSystemService( Context.ALARM_SERVICE ));
	}
	
	private void UnregisterAlarmBroadcast()
    {
        alarmManager.cancel(pendingIntent);
        getBaseContext().unregisterReceiver(mReceiver);
    }



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		alarmManager.set( AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5000) , pendingIntent );
	}



	public void SetButton(View view) throws InterruptedException 
	{
		Tic_or_Toe = R.drawable.kryds;
		//Tic_or_Toe = R.drawable.bolle;

		switch (view.getId()) {
		case R.id.ImageButton00:
			image = (ImageButton) findViewById(R.id.ImageButton00);
			if (theGame.UpdateBoard(0) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton01:
			image = (ImageButton) findViewById(R.id.ImageButton01);
			if (theGame.UpdateBoard(1) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton02:
			image = (ImageButton) findViewById(R.id.ImageButton02);
			if (theGame.UpdateBoard(2) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton03:
			image = (ImageButton) findViewById(R.id.ImageButton03);
			if (theGame.UpdateBoard(3) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton04:
			image = (ImageButton) findViewById(R.id.ImageButton04);
			if (theGame.UpdateBoard(4) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton05:
			image = (ImageButton) findViewById(R.id.ImageButton05);
			if (theGame.UpdateBoard(5) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton06:
			image = (ImageButton) findViewById(R.id.ImageButton06);
			if (theGame.UpdateBoard(6) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton07:
			image = (ImageButton) findViewById(R.id.ImageButton07);
			if (theGame.UpdateBoard(7) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		case R.id.ImageButton08:
			image = (ImageButton) findViewById(R.id.ImageButton08);
			if (theGame.UpdateBoard(8) == true) {
				image.setImageResource(Tic_or_Toe);
				correctMove = true;
			}
			break;

		default:
			break;
		}

		// Check for winner or Draw
		checkBoard();
		
		// bots turn
		if (correctMove == true) 
		{
//			if (theGame.BoardIsFull() == true) 
//			{
//				theGame.newGame();
//				cleanGUI();
//			}
			image = (ImageButton) findViewById(imagearray[theGame.moveBot()]);
			image.setImageResource(R.drawable.bolle);
			checkBoard();
			correctMove = false;
		}
		
		//theGame.changeTurn();

	}

	public void cleanGUI() 
	{
		for (int i = 0; i <= 8; i++) 
		{
			image = (ImageButton) findViewById(imagearray[i]);
			image.setImageResource(R.drawable.ingenting);
		}
	}

	public void checkBoard() 
	{
		String score;
	
		if (theGame.HasWinner() == true) 
		{
			correctMove = false;

			if (theGame.WhoWon() == BoardFieldEnum.PLAYER_X) 
			{
				theGame.updateScore();
				Context context = getApplicationContext();
				CharSequence text = "Kryds Vinder";
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();

				score = Integer.toString(theGame.getPlayerScore());
				TextView humanView = (TextView) findViewById(R.id.humanCount);
				humanView.setText(score);

				theGame.newGame();
				cleanGUI();

				correctMove = true;
			} 
			
			else 
			{
				theGame.updateScore();
				Context context = getApplicationContext();
				CharSequence text = "Bolle Vinder";
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();

				score = Integer.toString(theGame.getBotScore());
				TextView botView = (TextView) findViewById(R.id.androidCount);
				botView.setText(score);

				theGame.newGame();
				cleanGUI();

				correctMove = true;
			}

		} 
		
		if (theGame.BoardIsFull() == true) 
		{
			Context context = getApplicationContext();
			CharSequence text = "Pladen er fuld";
			int duration = Toast.LENGTH_LONG;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();

			theGame.newGame();
			cleanGUI();

			correctMove = true;
		}
	}	
}
