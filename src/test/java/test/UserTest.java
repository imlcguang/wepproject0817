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

	@Before
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

	 
	// 增加
	/*@Test
	public void testSaveUser() {
		T_User u = new T_User();
		u.setLoginName("cici");
		u.setPassword("aa");
		u.setUserName("aa3");
		u.setUserSex("0");
		u.setFunctionPopedom("123");
		session.save(u);
		System.out.println("新增成功！您的ID为：" + u.getUserID());
		// T_User u=new T_User(02, "01", "lily", "lily", "1",
		// "1111111");

	}*/

	/*// 修改
	public void testUpdateUser() {
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是修改操作:");
		System.out.println("请输入修改用户的ID");
		u = (T_User) session.get(T_User.class, scan.nextInt());

		System.out.println("您将进行的是修改操作序号:1：LoginName，2：Password，3：UserName" + "4：UserSex,5:FunctionPopedom");
		String sr = scan.next();
		switch (sr) {
		case "1": {
			System.out.println("请输入新用户编码");
			u.setLoginName(scan.next());
			break;
		}
		case "2": {
			System.out.println("请输入新用户密码");
			u.setPassword(scan.next());
			break;
		}
		case "3": {
			System.out.println("请输入新用户姓名");
			u.setUserName(scan.next());
			break;
		}
		case "4": {
			System.out.println("请输入新性别：0表示男,1表示女");
			u.setUserSex(scan.next());
			break;
		}
		case "5": {
			System.out.println("请输入新权限");
			u.setFunctionPopedom(scan.next());
			break;
		}

		default:
			break;
		}
		session.update(u);
		System.out.println("修改成功！");
	}*/

	/*// 删除
 @Test
	public void testDeleteUser() {
		T_User u = new T_User();
		u = (T_User) session.get(T_User.class, 1);
		session.delete(u);
		System.out.println("删除成功！");
	}*/
  

	// 查询

	/*public void testGetUser() {
		T_User u = new T_User();
		u = (T_User) session.get(T_User.class, 9);
		System.out.println(u);*/
	/*public  List<T_User> findByLoginName(String rname) throws Exception {
		Query query = session.createQuery("from T_User  where s.LoginName=?");
		
		query.setString(0,rname );
		
		List result = query.list();

		for (int i = 0; i < result.size(); i++) {
			T_User c = new T_User();
			T_User customer = (T_User) result.get(i);

			int modelid = customer.getUserID();
			System.out.println("id=" + modelid);
			c = (T_User) session.get(T_User.class, modelid);
			System.out.println("查询成功！");
			System.out.println(c);

		}
		return result;
	}*/
	

}
