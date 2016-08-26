package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class UserTest {
	private SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类
	private Transaction transaction;// 声明私有事务对象类
	private Configuration config;

/*	@Before
	public void init() {
		// 创建配置对象
		config = new Configuration().configure();
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
		System.out.println("before");

	}

	@After
	public void destory() {
		// 事务提交
		transaction.commit();
		// 会话关闭
		session.close();
		// 会话工厂关闭
		sessionFactory.close();
		System.out.println("after");
	}
*/
	 
	 @Test
	  public void testfindUserByLoginName(){
		  UserDao dao=new UserDao();
		  
		 T_User user=dao.findUserByLoginName("qwe");
		 System.out.println(user);
		  
	  }

}
