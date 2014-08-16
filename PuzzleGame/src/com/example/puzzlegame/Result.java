package com.example.puzzlegame;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity {

	private TextView txt2;
	int level;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.result);
		txt2=(TextView)findViewById(R.id.txt2);
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		switch (score)
		{
		case 1:if(score==1)
		{ 
			txt2.setText("your score is: "+score+"/"+5+" better luck next time");
		}break;
		case 2: if(score==2)
		{
			txt2.setText("your score is: " +score+"/"+5+" better luck next time ");
		}break;
		
		case 3:if(score==3)
		{
			txt2.setText("your score is: "+score+"/"+5+" try again");
		}break;
		case 4:if(score==4)
		{
			txt2.setText("your score is: "+score+"/"+5+" try again");
		}
		break;
		case 5:if(score==5)
		{
			
			Intent intent=new Intent(this, secondLevel.class);
			
			startActivity(intent);
			finish();
			
		}break;
		
	}
		
	}
	
	
		
}
