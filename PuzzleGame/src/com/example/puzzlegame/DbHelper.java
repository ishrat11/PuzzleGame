package com.example.puzzlegame;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_NAME = "triviaQuiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	private static final String TABLE_QUEST1 = "quest1";
	private static final String TABLE_QUEST2 = "quest2";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		
		
		
		String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST1 + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		
		
		String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST2 + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		
		
		db.execSQL(sql);
		addQuestions();
		db.execSQL(sql1);
		addQuestions1();
		db.execSQL(sql2);
		addQuestions2();
		//db.close();
	}
	private void addQuestions()
	{
		Question q1=new Question(" Mary's mum has 3 children.The first child is called April, "+
               " The second May. What is the name of the 3rd child?", "Mary","April", "May", "Mary");
		this.addQuestion(q1);
		Question q2=new Question(" Which one is not " +
				" a palindrome word?", "Fool","Civic", "Fool", "Dewed" );
		this.addQuestion(q2);
		Question q3=new Question(" A man has 12 hens all but 9 is dead." +
				" How many are alive?","9","3", "12","9");
		this.addQuestion(q3);
		Question q4=new Question(" It takes 5 machines 5 minutes to make 5 widgets." +
				" How long does it take 100 machines to make 100 widgets?","5",	"5", "100", "500");
		this.addQuestion(q4);
		Question q5=new Question(" Think of a number. Add 5 then Multiply by 2" +
				" Subtract 4 then Divide by 2.Ans is_","3","5","7","3");
		this.addQuestion(q5);
	}
	
	
	
	
	private void addQuestions1()
	{
		Question q1=new Question(" Jack sells apples in the market. First day he sells 1234 apples. Second day he sells 1456 " +
				"  On the third day, he sells 134 less than the second day. How many apples are sold in three days ?",
				" 4012 ","1322", "1801", " 4012 ");
		this.addQuestion1(q1);
		Question q2=new Question(" The poor have it,the rich want it,but if you eat it, you will die." +
				" What is this??", "Nothing","Happiness", "Nothing", "Sleep" );
		this.addQuestion1(q2);
		Question q3=new Question(" If EELS + MARK + BEST + WARY = EASY " +
				" What does HELP + BARK + WARD + LEAD equal?","HARD","EARD", "EADR","HARD");
		this.addQuestion1(q3);
		Question q4=new Question(" Can you discover the missing number in this series? "+
			"37- 10- 82, 29-11-47, 42-?-15",	"6",	"6", "12", "9");
		this.addQuestion1(q4);
		Question q5=new Question(" Cathy has twelve black socks and twelve white socks in her drawer. In complete darkness, and without looking" +
				" and without looking, how many socks must she take from the drawer in order to be sure to get a pair that match?",
				"3","2","5","3");
		this.addQuestion1(q5);
	}
	
	
	private void addQuestions2()
	{
		Question q1=new Question(" The day after tomorrow is the third day after Wednesday. " +
				" Which day was the day before yesterday ?","Tuesday","Saturday", "Monday", "Tuesday");
		this.addQuestion2(q1);
		Question q2=new Question(" How many times in a given day," +
				" minutes and hour clock comes in a straight line ??", "44","12", "44", "2" );
		this.addQuestion2(q2);
		Question q3=new Question(" There is a very small room in which four cats are sitting on the four corners. " +
				"Opposite to each cat are three cats and at each cat's tail, is one more cat." +
				" How many cats are sitting in that room all together?","4","20", "24","4");
		this.addQuestion2(q3);
		Question q4=new Question(" How many times can you subtract 5 from 25?", 
				"1",	"1", "5", "4");
		this.addQuestion2(q4);
		Question q5=new Question(" A certain street contains 100 buildings. They are numbered from 1 to 100. " +
				" How many 9's are used in these numbers?","20","19","99","20");
		this.addQuestion2(q5);
	}
	
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST1);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST2);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQuestion()); 
		values.put(KEY_ANSWER, quest.getAns());
		values.put(KEY_OPTA, quest.getC1());
		values.put(KEY_OPTB, quest.getC2());
		values.put(KEY_OPTC, quest.getC3());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);	
		//dbase.insert(TABLE_QUEST1, null, values);	
	//	dbase.insert(TABLE_QUEST2, null, values);
	}
	
	
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setId(cursor.getInt(0));
				quest.setQuestion(cursor.getString(1));
				quest.setAns(cursor.getString(2));
				quest.setC1(cursor.getString(3));
				quest.setC2(cursor.getString(4));
				quest.setC3(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
	
	public void addQuestion1(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQuestion()); 
		values.put(KEY_ANSWER, quest.getAns());
		values.put(KEY_OPTA, quest.getC1());
		values.put(KEY_OPTB, quest.getC2());
		values.put(KEY_OPTC, quest.getC3());
		// Inserting Row
		//dbase.insert(TABLE_QUEST, null, values);	
		dbase.insert(TABLE_QUEST1, null, values);	
	//	dbase.insert(TABLE_QUEST2, null, values);
	}
	
	
	public List<Question> getAllQuestions1() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST1;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setId(cursor.getInt(0));
				quest.setQuestion(cursor.getString(1));
				quest.setAns(cursor.getString(2));
				quest.setC1(cursor.getString(3));
				quest.setC2(cursor.getString(4));
				quest.setC3(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount1()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST1;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
	public void addQuestion2(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQuestion()); 
		values.put(KEY_ANSWER, quest.getAns());
		values.put(KEY_OPTA, quest.getC1());
		values.put(KEY_OPTB, quest.getC2());
		values.put(KEY_OPTC, quest.getC3());
		// Inserting Row
		//dbase.insert(TABLE_QUEST, null, values);	
		//dbase.insert(TABLE_QUEST1, null, values);	
		dbase.insert(TABLE_QUEST2, null, values);
	}
	
	
	public List<Question> getAllQuestions2() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST2;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setId(cursor.getInt(0));
				quest.setQuestion(cursor.getString(1));
				quest.setAns(cursor.getString(2));
				quest.setC1(cursor.getString(3));
				quest.setC2(cursor.getString(4));
				quest.setC3(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount2()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST2;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
	
	
	 public void closeDB() {
	        SQLiteDatabase db = this.getReadableDatabase();
	        if (db != null && db.isOpen())
	            db.close();
	    }
	
}
