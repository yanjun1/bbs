package cn.edu.qtech.vo;

import java.util.Date;

public class Post {
	
	private long id;
	
	private String content;
	
	private User user;
	
	private long parentId;
	
	private Subject subject;
	
	private Date createTime;
	
	private int isValidated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(int isValidated) {
		this.isValidated = isValidated;
	}
	
	

}
