package cn.edu.qtech.business.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.qtech.business.UserService;
import cn.edu.qtech.business.common.BusinessException;
import cn.edu.qtech.dao.DaoFactory;
import cn.edu.qtech.dao.UserDao;
import cn.edu.qtech.vo.User;

public class UserServiceImpl implements UserService{

	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	private UserDao userDao = DaoFactory.getUserDao();
	
	@Override
	public void registerUser(User user) throws BusinessException {
		try{
			
			userDao.saveUser(user);
		}catch(Exception e){
			logger.error("注册用户失败", e);
		}
	}

	@Override
	public boolean login(String username, String password, int roleId)
			throws BusinessException {
		return userDao.login(username, password, roleId);
		
	}

	@Override
	public User getUserById(long id) throws BusinessException {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public void updateUser(User user) throws BusinessException {
	try{
			userDao.saveUser(user);
		}catch(Exception e){
			logger.error("注册用户失败", e);
		}
		
	}

}
