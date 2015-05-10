package cn.edu.qtech.dao;

import org.hibernate.Query;

import cn.edu.qtech.db.HibernateUtils;
import cn.edu.qtech.vo.User;

public class UserDao {
	
	public void saveUser(User u){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		session.saveOrUpdate(u);
	}
	
	public boolean login(String username,String password,int roleId){
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Query q = session.createQuery("from User u where u.userName='"+username+"' and u.password='"+password+"' and u.roleId="+roleId);
		
		Object u = q.uniqueResult();
		if(u==null){
			return false;
		}
		return true;
	}

	public User getUserById(long userId) {
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Object user = session.get(User.class,userId);
		
		return (User)user;
		
	}

	public void updateUser(User user) {
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

}
