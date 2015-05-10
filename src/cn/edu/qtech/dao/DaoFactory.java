package cn.edu.qtech.dao;

public class DaoFactory {
	
	
	private static UserDao userDao = new UserDao();
	
	private static PictureDao pictureDao = new PictureDao();
	
	private static NoticeDao noticeDao = new NoticeDao();
	
	private static SectionDao sectionDao = new SectionDao();

	private static PostDao postDao = new PostDao();

	private static SubjectDao subjectDao = new SubjectDao();
	
	public static UserDao getUserDao(){
		return userDao;
	}
	public static PictureDao getPicDao(){
		return pictureDao;
	}
	public static NoticeDao getNoticeDao() {
		return noticeDao;
	}
	public static SectionDao getSectionDao() {
		return sectionDao;
	}
	public static PostDao getPostDao() {
		// TODO Auto-generated method stub
		return postDao ;
	}
	public static SubjectDao getSubjectDao() {
		// TODO Auto-generated method stub
		return subjectDao ;
	}
	
	
	
}
