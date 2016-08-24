package com.imlc.demo.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.imlc.demo.entity.T_User;
import com.imlc.demo.hibernate.SessionFactoryUtil;

public class LoginDao {
	private static SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类 
	private static Transaction transaction;// 声明私有事务对象类
	private static Configuration config;

	public static void init() {
		 session = SessionFactoryUtil.getInstance().getCurrentSession();  
		 transaction = session.beginTransaction();
	}

	public static void destory() {
		// 事务提交
		transaction.commit();
	}

	
	/*public static void finduser(String loginname,String password){
	String hql = "FROM T_User WHERE loginname = ? AND password = ?";
	List<T_User>list = session.createQuery(hql).setString(0, loginname).setString(1, password).list();
	if(list!=null)
		System.out.println("login success!");
	else 
		System.out.println("not found");
	}*/
	
	public static List<T_User> finduser(String loginname,String password) throws Exception {
		init();
		String hql = "FROM T_User WHERE loginname = ? AND password = ?";
		List result = session.createQuery(hql).setString(0, loginname).setString(1, password).list();
		//上面这一句空指针，有几个地方可能为空
		//session
		//session.createQuery()
		//..
		//因为是链式的引用，所以每一个为空都会异常。所以就一个个排插。
		//首先就发现了session没有值。。
		//找bug不是乱找，不是就是百度，要多想一想
	
		for (int i = 0; i < result.size(); i++) {
			T_User c = new T_User();
			T_User customer = (T_User) result.get(i);

			int modelid = customer.getUserID();
			System.out.println("id="+modelid);
			c = (T_User) session.get(T_User.class, modelid);
			System.out.println("这是找到了用户名"+c);

		}
		destory();
		return result;
		
	}
	/*public static List<T_User> findpassword(String password) throws Exception {
		init();
		String hql = "FROM T_User WHERE password = ? ";
		List result = session.createQuery(hql).setString(0, password).list();
	
	
		for (int i = 0; i < result.size(); i++) {
			T_User c = new T_User();
			T_User customer = (T_User) result.get(i);

			int modelid = customer.getUserID();
			System.out.println("id="+modelid);
			c = (T_User) session.get(T_User.class, modelid);
			System.out.println("这是找到了密码"+c);

		}
		destory();
		return result;
		
	}*/
	
	/*public static void main(String[] args) throws Exception {
		if(!finduser("c","d").isEmpty()){
			System.out.println("yes ");
		}
		else {
			System.out.println("no");
		}
			
	}*/
	
}
