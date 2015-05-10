package cn.edu.qtech.dao;

import java.util.List;

import org.hibernate.Query;

import cn.edu.qtech.db.HibernateUtils;
import cn.edu.qtech.vo.Post;

public class PostDao {

	public Post getPost(long id){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Object ret = session.get(Post.class,id);
		Post notice = (Post) ret;
		
		return notice;
	}
	
	public List<Post> getPostList( int offSet,int pageSize,int category){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createQuery("from Post s where s.category ="+category);
		if(offSet >0 && pageSize > 0){
			q.setFirstResult(offSet);
			q.setMaxResults(pageSize);
		}
		@SuppressWarnings("unchecked")
		List<Post> list = (List<Post>)q.list();
		return list;
	}
	
	public Integer getPostCount(){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from Post s where s.category = 3");
		Object ret = q.uniqueResult();
		
		return (Integer)ret;
		
	}
	

	public Post getLastPostBySection(long subjectId) {

		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createSQLQuery("from Post p where p.category = 3 and p.subjct.id="+subjectId+" order by p.create_time desc limit 1");
		Object ret = q.uniqueResult();
		return (Post)ret;
		
	}
	public Integer getSubjectPostNum(long subjectId){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createSQLQuery("select count(*) from Post p where p.category = 3 and p.subjct.id="+subjectId);
		Object ret = q.uniqueResult();
		
		return (Integer)ret;
	}
	
}
