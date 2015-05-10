package cn.edu.qtech.vo;

import java.util.Date;

public class Subject {
	private long id;
	
	private String title;
	
	private User user;


	private Section section;
	private int postNum;
	
	private Date createTime;

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
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
