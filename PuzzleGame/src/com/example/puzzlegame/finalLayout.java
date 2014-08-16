package com.example.puzzlegame;

import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;;

public class finalLayout extends Activity {

	private TextView txt5;
	private Button btn6,btn7;
	MediaPlayer player;
	AssetFileDescriptor afd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.second);
		txt5=(TextView)findViewById(R.id.txt3);
		btn6=(Button)findViewById(R.id.btn2);
		btn7=(Button)findViewById(R.id.btn3);
		
		txt5.setText("Congrats you have completed the mid level successfuly."
		+" are you ready for the final level?");
		
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
		
		Intent in=new Intent(this, finalLevel.class);
		startActivity(in);
		finish();
		}
	
	public void No(View v){
		Intent in=new Intent(this, MainActivity.class);
		startActivity(in);
	}
	
}
