package com.imlc.demo.dao;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.Destroyable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.imlc.demo.entity.T_User;

public class LoginDao {
	private static SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类
	private static Transaction transaction;// 声明私有事务对象类
	private static Configuration config;

	public static void init() {
		// 创建配置对象
		config = new Configuration().configure();
		// "src/main/resources/Hibernate.cfg.xml"
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		// 创建会话工程对象
		// sessionFactory = config.buildSessionFactory(serviceRegistry);
		sessionFactory = config.buildSessionFactory();
		// 会话对象
		session = sessionFactory.openSession();
		// 开启事务
		transaction = session.beginTransaction();
		// System.out.println("before");
	}

	public static void destory() {
		// 事务提交
		transaction.commit();
		// 会话关闭
		session.close();
		// 会话工厂关闭
		sessionFactory.close();
	}

	public static List<T_User> findByLoginName(String rname) throws Exception {
		Query query = session.createQuery("from T_User  where LoginName=?");

		query.setString(0, rname);

		List result = query.list();

		if (result.size() == 0)
			System.out.println("不存在该用户名");
		else {

			for (int i = 0; i < result.size(); i++) {
				T_User c = new T_User();
				T_User customer = (T_User) result.get(i);

				int modelid = customer.getUserID();
				System.out.println("id=" + modelid);
				c = (T_User) session.get(T_User.class, modelid);
				System.out.println("查询成功！");
				System.out.println(c);

			}
		}
		return result;
	}

	/*
	 * public static void testGetUser() { T_User u = new T_User(); Scanner scan
	 * = new Scanner(System.in);
	 * 
	 * System.out.println("您将进行的是查询操作:"); System.out.println("请输入查询用户的ID"); u =
	 * (T_User) session.get(T_User.class, scan.nextInt());
	 * System.out.println(u); System.out.println("查询成功！"); }
	 */

	public static void main(String[] args) throws Exception {
		init();
		findByLoginName("a");
		destory();
	}
}
