package cn.edu.qtech.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.qtech.business.SectionService;
import cn.edu.qtech.common.ConstantPool;
import cn.edu.qtech.dao.DaoFactory;
import cn.edu.qtech.dao.PostDao;
import cn.edu.qtech.dao.SectionDao;
import cn.edu.qtech.dao.SubjectDao;
import cn.edu.qtech.model.IndexSectionModel;
import cn.edu.qtech.vo.Section;
import cn.edu.qtech.vo.Subject;

public class SectionServiceImpl implements SectionService {

	SectionDao sectionDao = DaoFactory.getSectionDao();
	PostDao postDao = DaoFactory.getPostDao();
	SubjectDao subjectDao = DaoFactory.getSubjectDao();
	@Override
	public List<Section> getSectionList(int page,int category) {
		if(page <1){
			page = 1;
		}
		if(page > getPageCount()){
			page = getPageCount();
		}
		int offSet = (page - 1) * ConstantPool.PAGE_SIZE;
		List<Section> ret = sectionDao.getSectionList(offSet, ConstantPool.PAGE_SIZE,category);
		
		return ret;
	}

	@Override
	public Section getSection(long id) {
		// TODO Auto-generated method stub
		return sectionDao.getSection(id);
	}

	@Override
	public Integer getSectionCount() {
		// TODO Auto-generated method stub
		return sectionDao.getSectionCount();
	}

	@Override
	public Integer getPageCount() {
		Integer sectionCount = sectionDao.getSectionCount();
		int pageCount = (int) Math.ceil(sectionCount / ConstantPool.PAGE_SIZE);
		return pageCount;
	}

	@Override
	public List<IndexSectionModel> getIndexSectionList(List<Section> normalSections) {
		List<IndexSectionModel> ret = new ArrayList<IndexSectionModel>();
		for(Section section : normalSections){
			IndexSectionModel indexSectionModel = new IndexSectionModel();
			indexSectionModel.setPostCount(getPostNumBySection(section.getId()));
			indexSectionModel.setSubjectCount(subjectDao.getSubjectCount(section.getId()));
			ret.add(indexSectionModel);
		}	
		return ret;
	}
	
	
	private int getPostNumBySection(long sectionId){
		List<Subject> allSubjectList = subjectDao.getAllSubjectList(sectionId);
		int ret = 0;
		for(Subject subject : allSubjectList){
			int subjectPostNum = postDao.getSubjectPostNum(subject.getId());
			ret += subjectPostNum;
		}
		
		return ret;
		
	}

}
