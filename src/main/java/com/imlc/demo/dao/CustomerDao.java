package com.imlc.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_User;
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
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int  countrecord() {
		try {
			init();
			 int total = ((Long)this.session.createQuery("select count(id) from T_Customer ").uniqueResult()).intValue();
			 destory();
			 return total;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	/**
	 * 分页查询所有的信息
	 * 
	 * @return
	 */
	public List<T_Customer> findAllCus(int pageIndex, int pageSize) {
		Session session2 = SessionFactoryUtil.getInstance().openSession();
		// 获取query对象
		String hql = "from T_Customer order by CustomerID";
		Query hqlQuery = session2.createQuery(hql);

		// 从第几条记录开始查询
		hqlQuery.setFirstResult((pageIndex - 1) * pageSize);

		// 一共查询多少条记录
		hqlQuery.setMaxResults(pageSize);

		// 获取查询的结果
		List<T_Customer> result = hqlQuery.list();

		
		session2.close();
		return result;
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
	 * 修改客户信息
	 * 
	 * @param id
	 */
	public void updateCustomers(T_Customer c) {
		init();
		session.update(c);
		destory();
	}

	/**
	 * 删除 根据ID删除
	 */
	public void deleteCustomers(T_Customer c) {
		init();
		session.delete(c);
		destory();
	}

	/**
	 * 根据客户名ID查找客户
	 * 
	 * @param CustomerID
	 *            客户ID
	 * @return 根据客户名找到用户信息，如果没找到返回null
	 */
	public T_Customer findByCustomerID(Integer CustomerID) {
		init();
		T_Customer customer = (T_Customer) session.get(T_Customer.class, CustomerID);
		destory();
		return customer;
	}

	/**
	 * 根据客户名查找客户是否存在
	 * 
	 * @param CustomerName
	 *            客户名
	 * @return 根据客户名找到用户信息，如果没找到返回null
	 */
	public T_Customer findCustomerName(String CustomerName) {
		init();
		String hql = "FROM T_Customer WHERE CustomerName = :ctn ";
		List<T_Customer> result = session.createQuery(hql).setParameter("ctn", CustomerName).list();

		T_Customer customer = null; // (User)list;
		for (T_Customer customer2 : result)
			customer = customer2;
		destory();
		return customer;
	}

	/**
	 * 模糊查询按姓名、联系人、联系电话模糊查询
	 * 
	 * @param sname
	 * @return
	 * @throws Exception
	 */
	public static List<T_Customer> findCustByCond(T_Customer c) throws Exception {
		init();
		Query query = session.createQuery("from T_Customer as s where s.CustomerName like :cn and"
				+ " s.RelationName like :rn and s.RelationPhone like :rp");
		query.setParameter("cn", "%" + c.getCustomerName() + "%");
		query.setParameter("rn", "%" + c.getRelationName() + "%");
		query.setParameter("rp", "%" + c.getRelationPhone() + "%");
		List result = query.list();
		destory();
		return result;
	}

	/**
	 * 查询所有的信息
	 * 
	 * @return
	 */
	public List<T_Customer> findAllCus() {
		Session  session2= SessionFactoryUtil.getInstance().openSession();
		Query query = session2.createQuery("from T_Customer ");
		List result = query.list();
		session2.close();
		return result;

	}

}
