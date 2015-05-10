package cn.edu.qtech.dao;

import cn.edu.qtech.db.HibernateUtils;
import cn.edu.qtech.vo.Picture;

public class PictureDao {
	
	public void savePic(Picture picture) {
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		session.saveOrUpdate(picture);
	}
	
	public Picture getPicById(long id){
		
		org.hibernate.Session session = HibernateUtils.getCurrentSession();
		Object ret = session.get(Picture.class,id);
		
		Picture picture = (Picture)ret;
		
		return picture;
	}
}
