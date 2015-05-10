package cn.edu.qtech.business;

import cn.edu.qtech.business.common.BusinessException;
import cn.edu.qtech.vo.User;

public interface UserService {
	
	public void registerUser(User user) throws BusinessException;
	
	public boolean login(String username,String password,int roleId) throws BusinessException;
	public User getUserById(long userId) throws BusinessException;
	
	public void updateUser(User user) throws BusinessException;
}
