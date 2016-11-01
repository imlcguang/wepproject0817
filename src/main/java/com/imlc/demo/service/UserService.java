//检查用户、添加用户
package com.imlc.demo.service;

import java.util.List;

import com.imlc.demo.dao.UserDao;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;


public class UserService {
	
	private static UserService UserService=null;

	public static UserService getInstance(){
		if(UserService == null){
			UserService = new UserService();
		}
		return UserService;
	}

	private UserService(){
		
	}
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
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public List<T_User> findUserByName(String userName){
		return dao.findUserByName(userName);
	}
	
	/**
	 * 检查用户名密码是否正确
	 * @param loginname
	 * @param password
	 */
	public T_User isUser(String loginname,String password){
		return dao.findUserByLNandPsd(loginname, password);
	}
	
	/**
	 * 分页查询所有的用户信息
	 * 
	 * @return
	 */
	public List<T_User> findAllUser(int pageIndex, int pageSize) {
		return dao.findAllUser( pageIndex,  pageSize);
	}
	
	/**
	 * 查询所有的用户信息
	 * 
	 * @return
	 */
	public List<T_User> findAllUser() {
		return dao.findAllUser();
	}
	
	
	/**
	 * 统计总记录数
	 * @return
	 */
	public int  countrecord() {
		return dao.countrecord();
	}
	
	
	/**
	 * 按用户ID查找用户
	 * @param id
	 * @return
	 */
	public T_User findUserByID(Integer id){
		return dao.findUserByID(id);
	}
	/**
	 * 更新用户信息
	 * @param u
	 * @return
	 */
	public void updateUser(T_User u){
		 dao.updateUser(u);
	}
	/**
	 * 删除用户信息
	 * @param u
	 */
	public void deleteUser(T_User u){
		dao.deleteUse(u);
	}
}
