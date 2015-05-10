package cn.edu.qtech.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	private static Session session;
	static{
		try{
			Configuration cfg = new Configuration().configure();
			factory = cfg.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	public static Session getSession(){
		return session = factory.openSession();
	}
	public static Session getCurrentSession(){
		return session;
	}
	public static void  closeSession(Session session){
		if(session!=null){
			if(session.isOpen()){
				session.close();
			}
		}
	}
	
}
