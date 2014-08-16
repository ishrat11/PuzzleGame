package com.example.puzzlegame;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class rule extends Activity{

	private TextView txt3,txt4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.rule);
		txt3=(TextView)findViewById(R.id.txt3);
		txt4=(TextView)findViewById(R.id.txt3);
		Intent intent=getIntent();
		
		txt3.setText("In this game there are 3 levels. Easy level,Mid level and Hard level. "+
	             " Every level there will be 5 puzzles. You have to solve them with limited time."
				+" For easy level you will get 60 second,for mid level you will get 120 second and"
	             +" for hard level you will get 180 second. Although if you failed to solve that puzzle"
				+" within this time game will be finished, enjoy.");
		
		txt4.setText(
				" For easy level you will get 60 second,for mid level you will get 120 second and"
	             +" for hard level you will get 180 second. Although if you failed to solve that puzzle"
				+" within this time game will be finished, enjoy.");
	}
}
