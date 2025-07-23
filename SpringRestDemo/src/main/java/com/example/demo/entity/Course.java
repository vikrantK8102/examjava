package com.example.demo.entity;

public class Course {

	private long id;
	private String title;
	private String disciption;
	
	public Course() {}
	
	public Course(long id, String title, String disciption) {
		super();
		this.id = id;
		this.title = title;
		this.disciption = disciption;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDisciption() {
		return disciption;
	}

	public void setDisciption(String disciption) {
		this.disciption = disciption;
	}
	
	
	
}

