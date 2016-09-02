package com.imlc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.hibernate.SessionFactoryUtil;


public class BorrowRecordDao {
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
	 * 添加，借机登记
	 * @param m
	 */
	public void borrowRecord(T_BorrowRecord b) {
		init();
		session.save(b);
		System.out.println("新增成功！");
		destory();

	}
	
	/**
	 * 根据借机ID查找借机表
	 * 
	 * @param id
	 * @return
	 */
	public T_BorrowRecord findBorrowByID(String id) {
		init();
		Integer i=Integer.parseInt(id);
		T_BorrowRecord b = session.get(T_BorrowRecord.class, i);
		destory();
		return b;

	}
	
	
	/**
	 * 归还样机
	 * @param id
	 */
	public void returnRecord(T_BorrowRecord b) {
		init();
		session.update(b);
		destory();
	}
	
	
	

	/**
	 * 修改更新
	 * @param id
	 */
	public void updateBorrowRecord(T_BorrowRecord b) {
		init();
		session.update(b);
		destory();
	}

	/**
	 *  删除
	 * @param id
	 */
	public void deleteBorrowRecord(String id) {
		init();
		T_BorrowRecord b=findBorrowByID(id);
		session.delete(b);
		destory();
	}

	
	/**
	 * 查询所有的信息
	 * 
	 * @return
	 */
	public List<T_BorrowRecord> findAllBorrow() {
		init();
		Query query = session.createQuery("from T_BorrowRecord ");
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			T_BorrowRecord b = (T_BorrowRecord) result.get(i);
			System.out.println(b);
		}
		destory();
		return result;

	}
	/**
	 * 根据客户名称排序
	 * @param 
	 * @return
	 */
	public List<T_BorrowRecord> orderByCustomerID() {
		init();
		String hql = "FROM T_BorrowRecord order by CustomerID, ModelID, BorrowNumber";
		List<T_BorrowRecord> result = session.createQuery(hql).list();
		destory();
		return result;
	}
	
	/**
	 * 根据样机名称排序
	 * @param 
	 * @return
	 */
	public List<T_BorrowRecord> orderByModelID() {
		init();
		String hql = "FROM T_BorrowRecord order by ModelID,CustomerID,  BorrowNumber";
		List<T_BorrowRecord> result = session.createQuery(hql).list();
		destory();
		return result;
	}
	
}
