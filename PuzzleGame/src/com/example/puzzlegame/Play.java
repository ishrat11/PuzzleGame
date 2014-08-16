package com.example.puzzlegame;

import java.util.List;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Play extends Activity {

	private TextView txt,tv,tv1;
	private Button btn5;
	private RadioGroup group1;
	private RadioButton r1,r2,r3;
	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.game);
		
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		
		txt=(TextView)findViewById(R.id.textView1);
		tv=(TextView)findViewById(R.id.textView2);
		tv1=(TextView)findViewById(R.id.textView3);
		MyCount counter = new MyCount(60000,1000);
		counter.start();
		btn5=(Button)findViewById(R.id.button1);
		r1=(RadioButton)findViewById(R.id.radio0);
		r2=(RadioButton)findViewById(R.id.radio1);
		r3=(RadioButton)findViewById(R.id.radio2);
		setQuestionView();
		btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 group1=(RadioGroup)findViewById(R.id.group1);
				 RadioButton answer=(RadioButton)findViewById(group1.getCheckedRadioButtonId());
				 if(currentQ.getAns().equals(answer.getText()))
				 {
				 score++;
				 Log.d("score", "Your score"+score);
				 tv1.setText("Score:"+score);
				 }
				 
				 if(qid<5){
					 currentQ=quesList.get(qid);
					 setQuestionView();
					 }else{
					 Intent intent = new Intent(Play.this, Result.class);
					 Bundle b = new Bundle();
					 b.putInt("score", score); //Your score
					 intent.putExtras(b); //Put your score to your next Intent
					 startActivity(intent);
					 finish();
					 
					 }
					 
			}
		});
		db.closeDB();
		
		}
	private void setQuestionView()
	{
	txt.setText(currentQ.getQuestion());
	r1.setText(currentQ.getC1());
	r2.setText(currentQ.getC2());
	r3.setText(currentQ.getC3());
	qid++;
	}
	
	public class MyCount extends CountDownTimer{

		public MyCount(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
		//tv.setText(”done!”);
			tv.setText("Time Up!");
			finish();
			//Intent i=new Intent(Play.this,MainActivity.class);
			// startActivity(i);
		}

		@Override
		public void onTick(long millisUntilFinished) {
		tv.setText("Left: " + millisUntilFinished/1000 +"sec");

		}

		}
	
}
