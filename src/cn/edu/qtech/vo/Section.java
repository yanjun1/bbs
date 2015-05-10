package cn.edu.qtech.vo;

import java.util.Date;

public class Section {
	
	private long id;
	private String title;
	private long thumbnailId;
	private long bigPictureId;
	private int category; //1.推荐；2。活动中心；3。普通帖子
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
	public long getThumbnailId() {
		return thumbnailId;
	}
	public void setThumbnailId(long thumbnailId) {
		this.thumbnailId = thumbnailId;
	}
	public long getBigPictureId() {
		return bigPictureId;
	}
	public void setBigPictureId(long bigPictureId) {
		this.bigPictureId = bigPictureId;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
