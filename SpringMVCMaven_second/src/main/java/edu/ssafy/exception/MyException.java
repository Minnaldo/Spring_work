package edu.ssafy.exception;

public class MyException extends Exception{
	public MyException () {
		super("myException");
	}
	public void trace() {
		this.toString();
	}
}
