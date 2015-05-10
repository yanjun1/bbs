package cn.edu.qtech.model;

import cn.edu.qtech.vo.Subject;

public class SubjectListModel {
	
	private Subject subject;
	private int postNum;
	private String lastPostAuthor;
	private String lastPostTime;
	
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getLastPostAuthor() {
		return lastPostAuthor;
	}
	public void setLastPostAuthor(String lastPostAuthor) {
		this.lastPostAuthor = lastPostAuthor;
	}
	public String getLastPostTime() {
		return lastPostTime;
	}
	public void setLastPostTime(String lastPostTime) {
		this.lastPostTime = lastPostTime;
	}
	
	
	
}
