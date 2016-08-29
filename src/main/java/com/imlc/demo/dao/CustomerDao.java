package com.imlc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.hibernate.SessionFactoryUtil;

public class CustomerDao {
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
	 * 添加客户
	 * 
	 * @param c
	 *            要添加的用户信息
	 */

	public void AddCustomer(T_Customer c) {
		init();
		session.save(c);
		System.out.println("新增成功！您的ID为：" + c.getCustomerID());
		destory();
	}
	
	/**
	 * 根据客户名查找客户
	 * 
	 * @param CustomerName
	 *            客户名
	 * @return 根据客户名找到用户信息，如果没找到返回null
	 */
	public T_Customer findUserByCustomerName(String CustomerName) {
		init();
		String hql = "FROM T_Customer WHERE CustomerName = ? ";
		List<T_Customer> result = session.createQuery(hql).setString(0, CustomerName).list();

		T_Customer customer = null; // (User)list;
		for (T_Customer customer2 : result)
			customer = customer2 ;
		destory();
		return customer;
	}
	
	/**
	 * 模糊查询按名字
	 * @param sname
	 * @return
	 * @throws Exception
	 */
	public static List<T_Customer> findByCustomerName(String sname) throws Exception {
		init();
		Query query = session.createQuery("from T_Customer as s where s.CustomerName like :name");
		query.setString("name", "%" + sname + "%");
		List result = query.list();

		for (int i = 0; i < result.size(); i++) {
			T_Customer c = new T_Customer();
			T_Customer customer = (T_Customer) result.get(i);

			int customerid = customer.getCustomerID();
			c = (T_Customer) session.get(T_Customer.class, customerid);
			System.out.println("查询成功！");
			System.out.println(c);

		}
		destory();
		return result;
	}

	/**
	 * 模糊查询按联系人
	 * @param rname
	 * @return
	 * @throws Exception
	 */
	public static List<T_Customer> findByRelationName(String rname) throws Exception {
		init();
		Query query = session.createQuery("from T_Customer as s where s.RelationName like :name");
		query.setString("name", "%" + rname + "%");
		List result = query.list();

		for (int i = 0; i < result.size(); i++) {
			T_Customer c = new T_Customer();
			T_Customer customer = (T_Customer) result.get(i);

			int customerid = customer.getCustomerID();
			c = (T_Customer) session.get(T_Customer.class, customerid);
			System.out.println("查询成功！");
			System.out.println(c);

		}
		destory();
		return result;
	}
	
	/**
	 * 模糊查询按联系人电话
	 * @param rname
	 * @return
	 * @throws Exception
	 */
		public static List<T_Customer> findByRelationPhone(String rname) throws Exception {

			// String strSQL = "from T_Customer as s where s.CustomerName like
			// :name";
			init();
			Query query = session.createQuery("from T_Customer as s where s.RelationPhone like :name");
			query.setString("name", "%" + rname + "%");
			List result = query.list();

			for (int i = 0; i < result.size(); i++) {
				T_Customer c = new T_Customer();
				T_Customer customer = (T_Customer) result.get(i);

				int customerid = customer.getCustomerID();
				c = (T_Customer) session.get(T_Customer.class, customerid);
				System.out.println("查询成功！");
				System.out.println(c);
			}
			destory();
			return result;
		}
		
		/**
		 * 查询所有的信息
		 * @return
		 */
		public List<T_Customer> findAllCus(){
			init();
			Query query = session.createQuery("from T_Customer ");
			List result = query.list();
			for (int i = 0; i < result.size(); i++) {
				T_Customer c = new T_Customer();
				T_Customer customer = (T_Customer) result.get(i);

				int customerid = customer.getCustomerID();
				c = (T_Customer) session.get(T_Customer.class, customerid);
				System.out.println("查询成功！");
				System.out.println(c);
			}
			destory();
			return result;
			
		}
		/**
		 * 删除
		 */
		public void testDeleteCustomers(Integer id ) {
			init();
			T_Customer c = new T_Customer();
			System.out.println("您将进行的是删除操作:");
			c = (T_Customer) session.get(T_Customer.class, id);
			session.delete(c);
			System.out.println("删除成功！");
			destory();
		}
	
	
}
