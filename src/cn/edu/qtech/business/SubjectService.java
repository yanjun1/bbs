package cn.edu.qtech.business;

import java.util.List;

import cn.edu.qtech.model.SubjectListModel;
import cn.edu.qtech.vo.Subject;

public interface SubjectService {
	public List<SubjectListModel> getsubjectList(long sectionId, int page);
	
	public Subject getSubject(long id);
	public Integer getSubjectCount(long sectionId);
	public Integer getPageCount(long sectionId);
}
