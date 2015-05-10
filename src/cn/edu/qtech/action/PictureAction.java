package cn.edu.qtech.action;

import java.sql.Blob;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.edu.qtech.business.PicService;
import cn.edu.qtech.business.common.BusinessFactory;
import cn.edu.qtech.business.service.impl.PicServiceImpl;
import cn.edu.qtech.vo.Picture;

public class PictureAction extends DispatchAction{
	private static Log logger = LogFactory.getLog(ManagerAction.class);
	
	public ActionForward getPic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try{
			String picId = request.getParameter("picId");	
			PicService picService = (PicService)BusinessFactory.getBusiness(PicServiceImpl.class);
			Picture picture = picService.getPicById(Long.parseLong(picId));
			Blob blob = picture.getPic();
			long size = blob.length();
			byte[] bs = blob.getBytes(1, (int) size);
			response.setContentType("image/jpeg");
			response.setHeader("Cache-control", "no-cache ");
			ServletOutputStream outs = response.getOutputStream();
			outs.write(bs);
			outs.flush();
			
			return null;
		}catch(Exception e){
			logger.error("出错了", e);
			request.setAttribute("msg", e.getMessage());
			return mapping.findForward("error");	
		}
	}

}
