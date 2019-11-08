package edu.ssafy.boot.dto;

public class BoolResult {
	private String name;
	private boolean count = false;
	private String state = "true";
	public BoolResult() {}
	public BoolResult(String name, boolean count, String state) {
		this.name = name;
		this.count = count;
		this.state = state;
	}
}
