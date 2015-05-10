package cn.edu.qtech.business.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import cn.edu.qtech.business.PicService;
import cn.edu.qtech.business.common.BusinessException;
import cn.edu.qtech.common.ConstantPool;
import cn.edu.qtech.common.ImportActionForm;
import cn.edu.qtech.dao.DaoFactory;
import cn.edu.qtech.dao.PictureDao;
import cn.edu.qtech.dao.UserDao;
import cn.edu.qtech.vo.Picture;
import cn.edu.qtech.vo.User;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;

public class PicServiceImpl implements PicService{

	private PictureDao pictureDao = DaoFactory.getPicDao();
	
	private UserDao userDao = DaoFactory.getUserDao();
	
	@Override
	public void uploadPic(ActionForm actionForm, HttpServletRequest request) throws BusinessException {
		FileOutputStream fos = null;
		try{
			ImportActionForm upForm = (ImportActionForm) actionForm;
			FormFile formFile = upForm.getPhoto();
			String filename = formFile.getFileName();
			//todo 图片名称校验
			if(filename.indexOf("/") == -1){
				throw new BusinessException("文件名不合法");
			}
			
			long curVer = System.currentTimeMillis();
			String tarFileName = "";
			String fileTarFolder = ConstantPool.PIC_TARGET_FOLDER;
			if(fileTarFolder.endsWith("/")){
				tarFileName = fileTarFolder+curVer+"";
			}else{
				tarFileName = fileTarFolder+"/"+curVer+filename.substring(filename.lastIndexOf("."));
			}
			
			fos = new FileOutputStream(tarFileName);
			byte[] fileData = formFile.getFileData();
			fos.write(fileData);
			fos.flush();
		}catch(Exception e){
			throw new BusinessException(e.getMessage(), e);
		}finally{
			if(fos !=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new BusinessException("关闭文件出错", e);
				}
			}
		}
		
	}

	@Override
	public void uploadPic2DB(ActionForm actionForm, HttpServletRequest request,long userId)
			throws BusinessException {
		try{
			ImportActionForm upForm = (ImportActionForm) actionForm;
			FormFile formFile = upForm.getPhoto();
			String filename = formFile.getFileName();
			
			//todo 图片名称校验
			if(filename.indexOf(".") == -1){
				throw new BusinessException("文件名不合法");
			}
			
			Blob blob = Hibernate.createBlob(formFile.getInputStream());
			Picture picture = new Picture();
			picture.setFilename(filename);
			picture.setPic(blob);
			picture.setCreateTime(new Date());
			pictureDao.savePic(picture);
			User user = userDao.getUserById(userId);
			user.setPicId(picture.getId());
			userDao.updateUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage(), e);
		}
	}

	@Override
	public Picture getPicById(long picId) throws BusinessException {
		Picture pic = new Picture();
		try{
			pic = pictureDao.getPicById(picId);
		}catch(Exception e){
			throw new BusinessException(e.getMessage(), e);
		}
		return pic;
		
	}

	@Override
	public void updatePic2DB(ActionForm actionForm, HttpServletRequest request,
			long userId, long picId) throws BusinessException {
		try{
			ImportActionForm upForm = (ImportActionForm) actionForm;
			FormFile formFile = upForm.getPhoto();
			String filename = formFile.getFileName();
			
			//todo 图片名称校验
			if(filename.indexOf(".") == -1){
				throw new BusinessException("文件名不合法");
			}
			
			Blob blob = Hibernate.createBlob(formFile.getInputStream());
			Picture picture = pictureDao.getPicById(picId);
			picture.setFilename(filename);
			picture.setPic(blob);
			picture.setCreateTime(new Date());
			pictureDao.savePic(picture);
			User user = userDao.getUserById(userId);
			user.setPicId(picture.getId());
			userDao.updateUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage(), e);
		}
		
	}

}
