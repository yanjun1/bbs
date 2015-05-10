package cn.edu.qtech.dao;

import java.util.List;

import org.hibernate.Query;

import cn.edu.qtech.db.HibernateUtils;
import cn.edu.qtech.vo.Notice;
import cn.edu.qtech.vo.Picture;

public class NoticeDao {

	public Notice getNotice(long id){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Object ret = session.get(Picture.class,id);
		Notice notice = (Notice) ret;
		
		return notice;
	}
	
	public List<Notice> getNoticeList( int offSet,int pageSize){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createQuery("from Notice order by create_time desc");
		if(offSet >0 && pageSize > 0){
			q.setFirstResult(offSet);
			q.setMaxResults(pageSize);
		}
		@SuppressWarnings("unchecked")
		List<Notice> list = (List<Notice>)q.list();
		return list;
	}
	
	public Integer getNoticeCount(){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from Notice");
		Object ret = q.uniqueResult();
		
		return (Integer)ret;
		
	}
	
}
