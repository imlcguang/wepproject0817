package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserDao {
	private SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类
	private static Transaction transaction;// 声明私有事务对象类
	private Configuration config;

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
	 * 根据用户名查找用户
	 * 
	 * @param LoginName
	 *            登录名
	 * @return 根据登录名找到用户信息，如果没找到返回null
	 */
	public T_User findUserByLoginName(String LoginName) {
		init();
		String hql = "FROM T_User WHERE loginname = ? ";
		List<T_User> result = session.createQuery(hql).setString(0, LoginName).list();

		T_User user = null; // (User)list;
		for (T_User user2 : result)
			user = user2;
		destory();
		
		return user;
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
		String hql = "FROM T_User WHERE loginname = ? AND password = ? ";
		List<T_User> result = session.createQuery(hql).setString(0, loginname).setString(1, password).list();
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
