package com.kitri.project.movie.dto;

public class MovieDto {
	// MOVIE_INFO
	private int movie_no;
	private String movie_title;
	private String movie_poster;
	private String movie_genre;
	private String movie_story;
	private String movie_actor;
	private int movie_runningtime;

	// BRANCH_MOVIE
	private int branch_no;
	// private int movie_no; //equals MOVIE_INFO.movie_no
	private String movie_startdate;
	private String movie_enddate;
	// private int movie_count; //disable
	private String movie_start1;
	private String movie_start2;
	private String movie_start3;

	//BRANCH
//	private int branch_capacity;
	
	
	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	public String getMovie_story() {
		return movie_story;
	}

	public void setMovie_story(String movie_story) {
		this.movie_story = movie_story;
	}

	public String getMovie_actor() {
		return movie_actor;
	}

	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}

	public int getMovie_runningtime() {
		return movie_runningtime;
	}

	public void setMovie_runningtime(int movie_runningtime) {
		this.movie_runningtime = movie_runningtime;
	}

	public int getBranch_no() {
		return branch_no;
	}

	public void setBranch_no(int branch_no) {
		this.branch_no = branch_no;
	}

	public String getMovie_startdate() {
		return movie_startdate;
	}

	public void setMovie_startdate(String movie_startdate) {
		this.movie_startdate = movie_startdate;
	}

	public String getMovie_enddate() {
		return movie_enddate;
	}

	public void setMovie_enddate(String movie_enddate) {
		this.movie_enddate = movie_enddate;
	}

	public String getMovie_start1() {
		return movie_start1;
	}

	public void setMovie_start1(String movie_start1) {
		this.movie_start1 = movie_start1;
	}

	public String getMovie_start2() {
		return movie_start2;
	}

	public void setMovie_start2(String movie_start2) {
		this.movie_start2 = movie_start2;
	}

	public String getMovie_start3() {
		return movie_start3;
	}

	public void setMovie_start3(String movie_start3) {
		this.movie_start3 = movie_start3;
	}
/*
	public int getBranch_capacity() {
		return branch_capacity;
	}

	public void setBranch_capacity(int branch_capacity) {
		this.branch_capacity = branch_capacity;
	}

	*/
}
