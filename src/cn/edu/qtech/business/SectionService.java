package cn.edu.qtech.business;

import java.util.List;

import cn.edu.qtech.model.IndexSectionModel;
import cn.edu.qtech.vo.Section;


public interface SectionService {

public List<Section> getSectionList(int page,int category);
	
	public Section getSection(long id);
	
	public Integer getSectionCount();
	
	public Integer getPageCount();

	public List<IndexSectionModel> getIndexSectionList(List<Section> normalSections);
}
