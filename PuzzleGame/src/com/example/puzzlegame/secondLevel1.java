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

public class secondLevel1 extends Activity {

	TextView txt,tv,tv1;
	RadioButton rda, rdb, rdc;
	Button butNext;
	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
		setContentView(R.layout.second1);
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions1();
		currentQ=quesList.get(qid);
		txt=(TextView)findViewById(R.id.textView1);
		tv=(TextView)findViewById(R.id.textView2);
		tv1=(TextView)findViewById(R.id.textView3);
		MyCount counter = new MyCount(120000,1000);

		counter.start();
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		butNext=(Button)findViewById(R.id.button1);
		setQuestionView1();
		butNext.setOnClickListener(new View.OnClickListener() {		
			
			@Override
			public void onClick(View v) {
				RadioGroup grp=(RadioGroup)findViewById(R.id.group1);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getAns()+" "+answer.getText());
				if(currentQ.getAns().equals(answer.getText()))
				{
					score++;
					Log.d("score", "Your score"+score);
					tv1.setText("Score:"+score);
				}
				if(qid<5){					
					currentQ=quesList.get(qid);
					setQuestionView1();
				}else{
					Intent intent1 = new Intent(secondLevel1.this,Result1.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent1.putExtras(b); //Put your score to your next Intent
					startActivity(intent1);
					//finish();
				}
			}
		});
		db.closeDB();
	}
	
	
	private void setQuestionView1()
	{
		txt.setText(currentQ.getQuestion());
		rda.setText(currentQ.getC1());
		rdb.setText(currentQ.getC2());
		rdc.setText(currentQ.getC3());
		qid++;
	}
	public class MyCount extends CountDownTimer{

		public MyCount(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
		
			tv.setText("Time Up!");
			finish();
		}

		@Override
		public void onTick(long millisUntilFinished) {
		tv.setText("Left: " + millisUntilFinished/1000 +"sec");

		}

		}
}
