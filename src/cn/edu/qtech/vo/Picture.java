package cn.edu.qtech.vo;

import java.util.Date;

import java.sql.Blob;;

public class Picture {
	private long id;
	
	private String filename;
	private Blob pic;
	
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Blob getPic() {
		return pic;
	}

	public void setPic(Blob pic) {
		this.pic = pic;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
