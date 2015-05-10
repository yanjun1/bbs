package cn.edu.qtech.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ManagerAction extends DispatchAction  {
	private static Log logger = LogFactory.getLog(ManagerAction.class);
	
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			
			System.out.println("#########");
			return mapping.findForward("login");
		}catch(Exception e){
			logger.error("login error");
			return mapping.findForward("error");	
		}
	}
}
