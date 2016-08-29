//检查用户、添加用户
package com.imlc.demo.service;

import com.imlc.demo.dao.UserDao;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;


public class UserService {
	private UserDao dao=new UserDao();
	
/**
 * 添加用户
 * @param user
 * @throws MsgException 
 */
	public void registUser(T_User user) throws MsgException{
		//检查用户名是否存在，存在则提示
		if(dao.findUserByLoginName(user.getUserName())!=null){
			throw new MsgException("用户名已经存在");
		}
		//如果不存在，调用dao方法添加用户
		dao.testSaveUser(user);
	}
	
	/**
	 * 检查用户名密码是否正确
	 * @param loginname
	 * @param password
	 */
	public T_User isUser(String loginname,String password){
		return dao.findUserByLNandPsd(loginname, password);
	}
}
