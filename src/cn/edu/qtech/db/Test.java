package cn.edu.qtech.db;
import org.hibernate.Session;
public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
		System.out.println(session.isOpen());
		System.out.println("sss");
	}
}
