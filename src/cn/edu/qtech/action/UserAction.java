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
import cn.edu.qtech.common.ConstantPool;
import cn.edu.qtech.vo.User;

public class UserAction extends DispatchAction {
	
	private static Log logger = LogFactory.getLog(UserAction.class);
	
	
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{

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
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setCellphone(cellphone);
			user.seteMail(eMail);
			user.setQq(qq);
			user.setWeibo(weibo);
			user.setIntroduce(introduce);
			user.setRoleId(ConstantPool.ROLE_NORMAL);
			user.setPicId(ConstantPool.DEFAULT_PIC);
			
			UserService userService = (UserService)BusinessFactory.getBusiness(UserServiceImpl.class);
			userService.registerUser(user);
			
			request.setAttribute("userId", user.getId());
			return mapping.findForward("uploadPic");
		}catch(Exception e){
			logger.error("出错了", e);
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward uploadPhoto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try{
					
			PicService picService = (PicService)BusinessFactory.getBusiness(PicServiceImpl.class);
			String userId = request.getParameter("userId");
			picService.uploadPic2DB(form, request,Integer.parseInt(userId));
			
			response.sendRedirect("/videoBBS/open.do?method=adminUserIndex&userId="+userId);
			return null;
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String roleValue = request.getParameter("roleRadio");
			logger.info("username:"+userName+", roleRadio:"+roleValue);
			UserService userService = (UserService)BusinessFactory.getBusiness(UserServiceImpl.class);
			
			boolean isValided = userService.login(userName,password,Integer.parseInt(roleValue));
			
			if(isValided){
				return mapping.findForward("success");
			}else{
				request.setAttribute("msg", "用户名或者密码错误!");
				return mapping.findForward("info");
			}
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
	
	public ActionForward adminUserIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			String userId = request.getParameter("userId");
			UserService userService = (UserService)BusinessFactory.getBusiness(UserServiceImpl.class);
			User user = userService.getUserById(Long.parseLong(userId));
			request.setAttribute("user", user);
			return mapping.findForward("success");
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}
}
