package cn.edu.qtech.dao;

import java.util.List;

import org.hibernate.Query;

import cn.edu.qtech.db.HibernateUtils;
import cn.edu.qtech.vo.Section;

public class SectionDao {
	
public Section getSection(long id){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Object ret = session.get(Section.class,id);
		Section notice = (Section) ret;
		
		return notice;
	}
	
	public List<Section> getSectionList( int offSet,int pageSize,int category){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createQuery("from Section s where s.category ="+category);
		if(offSet >0 && pageSize > 0){
			q.setFirstResult(offSet);
			q.setMaxResults(pageSize);
		}
		@SuppressWarnings("unchecked")
		List<Section> list = (List<Section>)q.list();
		return list;
	}
	
	public Integer getSectionCount(){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from Section s where s.category = 3");
		Object ret = q.uniqueResult();
		
		return (Integer)ret;
		
	}

}
