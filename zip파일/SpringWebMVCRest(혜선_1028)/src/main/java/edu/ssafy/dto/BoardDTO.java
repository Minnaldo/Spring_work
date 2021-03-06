package edu.ssafy.dto;

public class BoardDTO {
	private String num;
	private String title;
	private String content;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BoardDTO(String num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}

	public BoardDTO() {
		super();
	}

	public BoardDTO(String num, String title, String content, String id) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", id=" + id + "]";
	}

}
