package com.example.project.model.board;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private int idx;
	private String title;
	private String contents;
	private String writer;
	private Date regdate;
	private int hit;
	private String name;
	private int cnt;
	private int cnt1;
	private String filename;
	private int likes;
	private MultipartFile file1;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCnt1() {
		return cnt1;
	}

	public void setCnt1(int cnt1) {
		this.cnt1 = cnt1;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", regdate=" + regdate + ", hit=" + hit + ", name=" + name + ", cnt=" + cnt + ", cnt1=" + cnt1
				+ ", filename=" + filename + ", likes=" + likes + ", file1=" + file1 + "]";
	}

}