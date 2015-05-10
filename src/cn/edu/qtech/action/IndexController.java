package cn.edu.qtech.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.edu.qtech.business.NoticeService;
import cn.edu.qtech.business.SectionService;
import cn.edu.qtech.business.common.BusinessFactory;
import cn.edu.qtech.business.service.impl.NoticeServiceImpl;
import cn.edu.qtech.business.service.impl.SectionServiceImpl;
import cn.edu.qtech.common.SectionCategroy;
import cn.edu.qtech.model.IndexSectionModel;
import cn.edu.qtech.vo.Notice;
import cn.edu.qtech.vo.Section;

public class IndexController {
	private static Log logger = LogFactory.getLog(UserAction.class);
	
	public ActionForward uploadPhoto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try{
			NoticeService noticeService = (NoticeService)BusinessFactory.getBusiness(NoticeServiceImpl.class);
			List<Notice> noticeList = noticeService.getNoticeList(1);
			
			SectionService sectionService = (SectionService)BusinessFactory.getBusiness(SectionServiceImpl.class);
			
			List<Section> recommandSections = sectionService.getSectionList(1,SectionCategroy.RECOMMAND.value);
			
			List<Section> activities = sectionService.getSectionList(1,SectionCategroy.ACTIVITY.value);
			List<Section> normalSections = sectionService.getSectionList(-1,SectionCategroy.NORMAL.value);
			List<IndexSectionModel> indexSectionList = sectionService.getIndexSectionList(normalSections);
			
			request.setAttribute("notices", noticeList);
			request.setAttribute("recommandSection", recommandSections.get(recommandSections.size()-1));
			request.setAttribute("activitySection", activities.get(activities.size()-1));
			request.setAttribute("normalSections", indexSectionList);
			
			
			
				
			return mapping.findForward("index");
		}catch(Exception e){
			logger.error("出错了",e);
			return mapping.findForward("error");
		}
		
			
	}
	
}
