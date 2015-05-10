package cn.edu.qtech.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


import cn.edu.qtech.business.PicService;
import cn.edu.qtech.business.UserService;
import cn.edu.qtech.business.common.BusinessFactory;
import cn.edu.qtech.business.service.impl.PicServiceImpl;
import cn.edu.qtech.business.service.impl.UserServiceImpl;
import cn.edu.qtech.vo.User;

public class AdminUserAction extends DispatchAction {
	
	private static Log logger = LogFactory.getLog(AdminUserAction.class);
	
	public ActionForward modifyInfoPre(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			String userId = request.getParameter("userId");
			UserService userService = (UserService)BusinessFactory.getBusiness(UserServiceImpl.class);
			User user = userService.getUserById(Long.parseLong(userId));
			request.setAttribute("user", user);
			return mapping.findForward("modifyPage");
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward modifyPicturePre(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			String userId = request.getParameter("userId");
			UserService userService = (UserService)BusinessFactory.getBusiness(UserServiceImpl.class);
			User user = userService.getUserById(Long.parseLong(userId));
			request.setAttribute("user", user);
			return mapping.findForward("modifyPicPage");
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward modifyInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			UserService userService = (UserService)BusinessFactory.getBusiness(UserServiceImpl.class);
			String userId = request.getParameter("userId");
			
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("rePassword");
			String eMail = request.getParameter("eMail");
			String weibo = request.getParameter("weibo");
			String cellphone = request.getParameter("cellphone");
			String qq = request.getParameter("qq");
			String introduce = request.getParameter("introduce");
			
			if(!password.equals(rePassword)){
				request.setAttribute("msg", "两次密码不一致");
				return mapping.findForward("info");
			}
			//TODO 验证参数合法性
			User user = userService.getUserById(Long.parseLong(userId));
			user.setUserName(userName);
			user.setPassword(password);
			user.setCellphone(cellphone);
			user.seteMail(eMail);
			user.setQq(qq);
			user.setWeibo(weibo);
			user.setIntroduce(introduce);
			user.setId(Long.parseLong(userId));
			
			userService.updateUser(user);
			response.sendRedirect("/videoBBS/open.do?method=adminUserIndex&userId="+userId);
			return null;
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward modifyPic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			PicService picService = (PicService)BusinessFactory.getBusiness(PicServiceImpl.class);
			String userId = request.getParameter("userId");
			String picId = request.getParameter("picId");
			picService.updatePic2DB(form, request,Long.parseLong(userId),Long.parseLong(picId));
			
			response.sendRedirect("/videoBBS/open.do?method=adminUserIndex&userId="+userId);
			return null;
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	
}
