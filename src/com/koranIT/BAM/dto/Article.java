package com.koranIT.BAM.dto;

import java.util.Objects;

public class Article{
	private int id;
	private String regDate;
	private String title;
	private String body;
	private int viewCnt;
	
	public Article(int id, String regDate, String title, String body, int viewCnt){
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.viewCnt = viewCnt;
	}
	
	public void increaseViewCnt() {
		this.viewCnt++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(body, id, regDate, title, viewCnt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(body, other.body) && id == other.id && Objects.equals(regDate, other.regDate)
				&& Objects.equals(title, other.title) && viewCnt == other.viewCnt;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", title=" + title + ", body=" + body + ", viewCnt="
				+ viewCnt + "]";
	}
	
}