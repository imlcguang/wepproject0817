package com.imlc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.hibernate.SessionFactoryUtil;


public class HibernateRecordDao {
	
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
	
	public List<T_BorrowRecord> findRecord(int pageIndex,int pageSize) {
		
		// 存放所有查询出的对象
	
		try {
			Session session2 = SessionFactoryUtil.getInstance().openSession();
			
			// 获取query对象
			String hql ="from T_BorrowRecord ";
			Query hqlQuery = session2.createQuery(hql);
			
			
			// 从第几条记录开始查询
			hqlQuery.setFirstResult((pageIndex-1)*pageSize);
			
			// 一共查询多少条记录
			hqlQuery.setMaxResults(pageSize);
			
			// 获取查询的结果
			List<T_BorrowRecord> recordResult = hqlQuery.list();
			
			/*for (int i = 0; i < recordResult.size(); i++) {
				T_BorrowRecord c = new T_BorrowRecord();
				T_BorrowRecord user = (T_BorrowRecord) recordResult.get(i);

				int userid = user.getBorrowNo();
				c = (T_BorrowRecord) session2.get(T_BorrowRecord.class, userid);
				System.out.println("看这边~~~");
				System.out.println(c);
			}*/
			
			session2.close();
			return recordResult;
			
		} catch (Exception e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} 
	}
	

}
