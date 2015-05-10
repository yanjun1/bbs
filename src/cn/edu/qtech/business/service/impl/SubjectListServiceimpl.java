package cn.edu.qtech.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.qtech.business.SubjectService;
import cn.edu.qtech.common.ConstantPool;
import cn.edu.qtech.dao.DaoFactory;
import cn.edu.qtech.dao.PostDao;
import cn.edu.qtech.dao.SubjectDao;
import cn.edu.qtech.model.SubjectListModel;
import cn.edu.qtech.utils.DateUtils;
import cn.edu.qtech.vo.Post;
import cn.edu.qtech.vo.Subject;

public class SubjectListServiceimpl implements SubjectService {

	private SubjectDao subjectDao = DaoFactory.getSubjectDao();
	
	private PostDao postDao = DaoFactory.getPostDao();
	
	@Override
	public List<SubjectListModel> getsubjectList(long sectionId, int page) {
		if(page <1){
			page = 1;
		}
		if(page > getPageCount(sectionId)){
			page = getPageCount(sectionId);
		}
		int offSet = (page - 1) * ConstantPool.PAGE_SIZE;
		List<Subject> subjects = subjectDao.getSubjectList(offSet, ConstantPool.PAGE_SIZE,sectionId);
		List<SubjectListModel> ret = new ArrayList<SubjectListModel>();
		for(Subject s : subjects){
			SubjectListModel subjectListModel = new SubjectListModel();
			Post lastPost = postDao.getLastPostBySection(s.getId());	
			subjectListModel.setLastPostAuthor(lastPost.getUser().getUserName());
			subjectListModel.setLastPostTime(DateUtils.formatDate2yyymmdd(lastPost.getCreateTime()));
			subjectListModel.setPostNum(postDao.getSubjectPostNum(s.getId()));
			ret.add(subjectListModel);
		}
		return ret;
	}

	@Override
	public Subject getSubject(long id) {
		return subjectDao.getSubject(id);
	}

	@Override
	public Integer getSubjectCount(long sectionId) {
		return subjectDao.getSubjectCount(sectionId);
	}

	@Override
	public Integer getPageCount(long sectionId) {
		Integer SubjectCount = subjectDao.getSubjectCount(sectionId);
		int pageCount = (int) Math.ceil(SubjectCount / ConstantPool.PAGE_SIZE);
		return pageCount;
	}
}
