package cn.edu.qtech.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.edu.qtech.business.SubjectService;
import cn.edu.qtech.business.common.BusinessFactory;
import cn.edu.qtech.business.service.impl.SubjectListServiceimpl;
import cn.edu.qtech.model.SubjectListModel;

public class SubjectListAction {
	
	private static Log logger = LogFactory.getLog(ManagerAction.class);
	
	public ActionForward getSubjectListPre(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			
			
			return getSubjectList(mapping,request,response);
		}catch(Exception e){
			logger.error("login error");
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward getSubjectList(ActionMapping mapping,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			String sectionIdStr = request.getParameter("sectionId");
			SubjectService subjectService = (SubjectService)BusinessFactory.getBusiness(SubjectListServiceimpl.class);
			String pageStr = request.getParameter("page");
			int sectionId = Integer.parseInt(sectionIdStr);
			int page = 1;
			if(pageStr == null || "".equals(pageStr)){
				page = 1;
			}
			Integer allsubjectCount = subjectService.getSubjectCount(sectionId);
			page = page <1 ? 1: Integer.parseInt(pageStr);
			page = page > allsubjectCount ? allsubjectCount : Integer.parseInt(pageStr);
			
			List<SubjectListModel> subjectList = subjectService.getsubjectList(sectionId, page);
			
			request.setAttribute("subjectList", subjectList);
			
			return mapping.findForward("success");
		}catch(Exception e){
			logger.error("login error");
			return mapping.findForward("error");	
		}
	}
}
