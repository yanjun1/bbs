package cn.edu.qtech.model;

import cn.edu.qtech.vo.Section;

public class IndexSectionModel {
	
	private Section section;
	
	private int subjectCount;
	
	private int postCount;

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public int getSubjectCount() {
		return subjectCount;
	}

	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	
	
}
