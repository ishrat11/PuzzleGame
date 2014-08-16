package com.example.puzzlegame;

public class Question {

	private int id;
	private String question;
	private String ans;
	private String c1,c2,c3;
	
	
	
	
	public Question() {
		
	}




	
	
	public Question(String question, String ans, String c1, String c2, String c3) {
		
		this.question = question;
		this.ans = ans;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}






	public Question(int id, String question, String ans, String c1, String c2,
			String c3) {
		
		this.id = id;
		this.question = question;
		this.ans = ans;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getQuestion() {
		return question;
	}






	public void setQuestion(String question) {
		this.question = question;
	}






	public String getAns() {
		return ans;
	}






	public void setAns(String ans) {
		this.ans = ans;
	}






	public String getC1() {
		return c1;
	}






	public void setC1(String c1) {
		this.c1 = c1;
	}






	public String getC2() {
		return c2;
	}






	public void setC2(String c2) {
		this.c2 = c2;
	}






	public String getC3() {
		return c3;
	}






	public void setC3(String c3) {
		this.c3 = c3;
	}






	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", ans=" + ans
				+ ", c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + "]";
	}
	
	
	
	
}
