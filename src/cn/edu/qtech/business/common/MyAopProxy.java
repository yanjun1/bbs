package cn.edu.qtech.business.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.qtech.db.HibernateUtils;


public class MyAopProxy implements InvocationHandler{
	private Object target;
	public MyAopProxy(@SuppressWarnings("rawtypes") Class targetClass){
		try {
			target = targetClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Session session = null;
		Object ret = null;
		try{
			System.out.println(target+"."+method.getName()+"()will be called");
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			
			ret = method.invoke(target, args);
			
			tx.commit();
			System.out.println(method.getName()+"()had been invoked sucessfully");
			
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("Business have Exception !!!!!!!!!!");
			e.printStackTrace();
			throw new BusinessException("BusinessException Transaction rollback",e);
		}finally{
			HibernateUtils.closeSession(session);
		}
		return ret;
	}
	
}
