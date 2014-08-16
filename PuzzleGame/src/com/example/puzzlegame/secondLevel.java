package com.example.puzzlegame;

import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondLevel extends Activity

{
	private TextView txt3;
	private Button btn2,btn3;
	MediaPlayer player;
	AssetFileDescriptor afd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.second);
		
	
		txt3=(TextView)findViewById(R.id.txt3);
		btn2=(Button)findViewById(R.id.btn2);
		btn3=(Button)findViewById(R.id.btn3);
		
		txt3.setText("Congrats you have completed the first level successfuly."
		+" are you ready for the next level?");
		
		try {
			// Read the music file from the asset folder
			afd = getAssets().openFd("home.mp3");
			// Creation of new media player;
			player = new MediaPlayer();
			// Set the player music source.
			player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),afd.getLength());
			// Set the looping and play the music.
			//player.setLooping(true);
			player.prepare();
			player.start();
			} catch (IOException e) {
			e.printStackTrace();
			}
	
	}
	
	 public void Yes(View v){
		
		Intent in=new Intent(this, secondLevel1.class);
		startActivity(in);
		finish();
		}
		
		public void No(View v){
			//finish();
			Intent in=new Intent(this, MainActivity.class);
			startActivity(in);
		}
	
}
