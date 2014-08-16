package com.example.puzzlegame;

import java.io.IOException;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class Final_Result extends Activity {

	private TextView txt8,txt9;
	MediaPlayer player;
	AssetFileDescriptor afd;
	Question currentQ;
	List<Question> quesList;
	int qid=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.final_result);
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		txt8=(TextView)findViewById(R.id.txt8);
		txt9=(TextView)findViewById(R.id.txt9);
		txt8.setText("Congrats you have completed all the level successfully."+
		" your total score is 15 out of 15");
		
		//setAnsview();
		
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
	/*private void setAnsview(){
		 if(qid<5){
			 currentQ=quesList.get(qid);
			
		txt9.setText(currentQ.getAns());
		qid++;
	}
		 else{
			 
		 }
}*/
}