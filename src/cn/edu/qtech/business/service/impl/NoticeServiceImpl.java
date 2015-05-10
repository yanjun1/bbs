package cn.edu.qtech.business.service.impl;

import java.util.List;

import cn.edu.qtech.business.NoticeService;
import cn.edu.qtech.common.ConstantPool;
import cn.edu.qtech.dao.DaoFactory;
import cn.edu.qtech.dao.NoticeDao;
import cn.edu.qtech.vo.Notice;

public class NoticeServiceImpl implements NoticeService{
		private NoticeDao noticeDao = DaoFactory.getNoticeDao();

		@Override
		public List<Notice> getNoticeList(int page) {
			if(page <1){
				page = 1;
			}
			if(page > getPageCount()){
				page = getPageCount();
			}
			int offSet = (page - 1) * ConstantPool.PAGE_SIZE;
			List<Notice> ret = noticeDao.getNoticeList(offSet, ConstantPool.PAGE_SIZE);
			
			return ret;
		}

		@Override
		public Notice getNotice(long id) {
			Notice ret;
			ret = noticeDao.getNotice(id);
			return ret;
		}

		@Override
		public Integer getNoticeCount() {
			// TODO Auto-generated method stub
			return noticeDao.getNoticeCount();
		}

		@Override
		public Integer getPageCount() {
			Integer noticeCount = noticeDao.getNoticeCount();
			int pageCount = (int) Math.ceil(noticeCount / ConstantPool.PAGE_SIZE);
			return pageCount;
		}
		
		
		
		
}
