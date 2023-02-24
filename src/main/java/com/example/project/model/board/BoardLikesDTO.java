package com.example.project.model.board;

public class BoardLikesDTO {
	private int likes_no;
	private int board_idx;
	private String userid;
	private int likes;
	public int getLikes_no() {
		return likes_no;
	}
	public void setLikes_no(int likes_no) {
		this.likes_no = likes_no;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "BoardLikesDTO [likes_no=" + likes_no + ", board_idx=" + board_idx + ", userid=" + userid + ", likes="
				+ likes + "]";
	}
	
	
}
