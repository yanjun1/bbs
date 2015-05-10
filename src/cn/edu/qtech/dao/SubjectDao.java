package cn.edu.qtech.dao;

import java.util.List;

import org.hibernate.Query;

import cn.edu.qtech.db.HibernateUtils;
import cn.edu.qtech.vo.Subject;

public class SubjectDao {
public Subject getSubject(long id){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Object ret = session.get(Subject.class,id);
		Subject subject = (Subject) ret;
		
		return subject;
	}
	
	public List<Subject> getSubjectList( int offSet,int pageSize,long sectionId){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createQuery("from Subject s where s.sectionId = " + sectionId);
		if(offSet >0 && pageSize > 0){
			q.setFirstResult(offSet);
			q.setMaxResults(pageSize);
		}
		@SuppressWarnings("unchecked")
		List<Subject> list = (List<Subject>)q.list();
		return list;
	}
	
	public Integer getSubjectCount(long sectionId){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from Subject s where s.sectionId =" + sectionId);
		Object ret = q.uniqueResult();
		
		return (Integer)ret;
		
	}

	public List<Subject> getAllSubjectList(long sectionId) {
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createQuery("from Subject s where s.sectionId = " + sectionId);
		@SuppressWarnings("unchecked")
		List<Subject> list = (List<Subject>)q.list();
		return list;
	}
	
}
