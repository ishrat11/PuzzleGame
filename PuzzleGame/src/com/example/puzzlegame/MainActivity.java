package com.example.puzzlegame;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	
	private Button btn1,btn3,btn4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.activity_main);
		btn1=(Button)findViewById(R.id.btn1);
		
		btn3=(Button)findViewById(R.id.btn3);
		btn4=(Button)findViewById(R.id.btn4);
		//Intent i=getIntent();
		
			
	}
  public void Play(View v){
	
	Intent in=new Intent(this, Play.class);
	startActivity(in);
	finish();
  }

  public void Rules(View v){
	  Intent in=new Intent(this, rule.class);
		startActivity(in);
		finish();
	  }
  
  public void Exit(View v){
	 finish();
	  }
  
}
