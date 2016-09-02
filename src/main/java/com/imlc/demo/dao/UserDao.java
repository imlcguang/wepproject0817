package com.imlc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.hibernate.SessionFactoryUtil;

public class UserDao {
	private static Session session;// 声明私有会话对象类
	private static Transaction transaction;// 声明私有事务对象类

	public static void init() {
		session = SessionFactoryUtil.getInstance().getCurrentSession();
		// 开启事务
		transaction = session.beginTransaction();
	}

	public static void destory() {
		// 事务提交
		transaction.commit();
	}

	/**
	 * 根据用户ID查找用户
	 * 
	 * @param id
	 * @return
	 */
	public T_User findUserByID(Integer id) {
		init();
		T_User user = session.get(T_User.class, id);
		destory();
		return user;

	}
	
	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 * @return 根据用户名找到用户信息，如果没找到返回null
	 */
	public List<T_User> findUserByName(String userName) {
		init();
		String hql = "FROM T_User WHERE userName like :uname ";
		List<T_User> result = session.createQuery(hql).setParameter("uname","%" + userName + "%").list();
		destory();
		return result;
	}
	
	/**
	 * 根据用户名查找用户
	 * 
	 * @param LoginName
	 *            登录名
	 * @return 根据登录名找到用户信息，如果没找到返回null
	 */
	public T_User findUserByLoginName(String LoginName) {
		init();
		String hql = "FROM T_User WHERE loginname = :lgn ";
		List<T_User> result = session.createQuery(hql).setParameter("lgn", LoginName).list();

		T_User user = null; // (User)list;
		for (T_User user2 : result)
			user = user2;
		destory();

		return user;
	}

	/**
	 * 查询所有的信息
	 * 
	 * @return
	 */
	public List<T_User> findAllUser() {
		init();
		Query query = session.createQuery("from T_User ");
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			T_User c = new T_User();
			T_User user = (T_User) result.get(i);

			int userid = user.getUserID();
			c = (T_User) session.get(T_User.class, userid);
			System.out.println("查询成功！");
			System.out.println(c);
		}
		destory();
		return result;

	}
	/**
	 * 更新用户信息
	 * @param u
	 * @return
	 */
	public void  updateUser(T_User u){
		init();
		session.update(u);
		destory();
		
	}
	/**
	 * 删除用户
	 * @param u
	 */
	public void deleteUse(T_User u){
		init();
		session.delete(u);
		destory();
	}

	/**
	 * 添加用户
	 * 
	 * @param u
	 *            要添加的用户信息
	 */

	public void testSaveUser(T_User u) {
		init();
		session.save(u);
		System.out.println("新增成功！您的ID为：" + u.getUserID());
		destory();
	}

	/**
	 * 根据用户名密码查找对应的用户
	 * 
	 * @param loginname
	 * @param password
	 * @return 找到的用户，找不到则返回null
	 */

	public T_User findUserByLNandPsd(String loginname, String password) {
		init();
		String hql = "FROM T_User WHERE loginname = :lgn  AND password = :psw ";
		List<T_User> result = session.createQuery(hql).setParameter("lgn", loginname).setParameter("psw", password).list();
		// 上面这一句空指针，有几个地方可能为空 1.session 2.session.createQuery() 3....
		// 因为是链式的引用，所以每一个为空都会异常。所以就一个个排插。
		// 找bug不是乱找，不是就是百度，要多想一想
		T_User user = null; // (User)list;
		for (T_User user2 : result)
			user = user2;
		destory();
		return user;
	}
}
