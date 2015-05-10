package cn.edu.qtech.business;

import java.util.List;

import cn.edu.qtech.vo.Notice;

public interface NoticeService {
	
	public List<Notice> getNoticeList(int page);
	
	public Notice getNotice(long id);
	
	public Integer getNoticeCount();
	
	public Integer getPageCount();
	
}
