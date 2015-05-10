package cn.edu.qtech.business;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import cn.edu.qtech.business.common.BusinessException;
import cn.edu.qtech.vo.Picture;

public interface PicService {
	
	public void uploadPic(ActionForm actionForm, HttpServletRequest request)throws BusinessException;
	public void uploadPic2DB(ActionForm actionForm, HttpServletRequest request,long userId)throws BusinessException;
	public Picture getPicById(long picId) throws BusinessException;
	public void updatePic2DB(ActionForm actionForm, HttpServletRequest request,long userId,long picId)throws BusinessException;
}
