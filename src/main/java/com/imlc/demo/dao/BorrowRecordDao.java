package com.imlc.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_Count;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.hibernate.SessionFactoryUtil;

public class BorrowRecordDao {
	private static Session session;// 声明私有会话对象类
	private static Transaction transaction;// 声明私有事务对象类

	public static void init() {
		session = SessionFactoryUtil.getInstance().getCurrentSession();
		// 开启事务
		transaction =session.beginTransaction();
	}

	public static void destory() {
		// 事务提交
		transaction.commit();

	}

	/**
	 * 添加，借机登记
	 * 
	 * @param m
	 */
	public void borrowRecord(T_BorrowRecord b) {
		try {
			init();
			session.save(b);
			destory();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	/**
	 * 根据借机ID查找借机表
	 * 
	 * @param id
	 * @return
	 */
	public T_BorrowRecord findBorrowByID(String id) {
		try {
			Session session1 = SessionFactoryUtil.getInstance().openSession();
			Integer i = Integer.parseInt(id);
			T_BorrowRecord b = session1.get(T_BorrowRecord.class, i);
			session1.close();
			return b;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			T_BorrowRecord br = new T_BorrowRecord();
			return br;
		}
	}

	/**
	 * 归还样机
	 * 
	 * @param id
	 */
	public void returnRecord(T_BorrowRecord b) {
		try {
			init();
			session.update(b);
			destory();
		} catch (Exception e) {
			e.printStackTrace();
			// transaction.rollback();
		}

	}

	/**
	 * 修改更新
	 * 
	 * @param id
	 */
	public void updateBorrowRecord(T_BorrowRecord b) {
		try {
			init();
			session.update(b);
			destory();
		} catch (Exception e) {
			e.printStackTrace();
			// transaction.rollback();
		}

	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteBorrowRecord(T_BorrowRecord b) {
		try {
			init();
			session.delete(b);
			destory();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

	}

	/**
	 * 查询所有的信息
	 * 
	 * @return
	 */
	public List<T_BorrowRecord> findAllBorrow() {

		try {
			Session session2 = SessionFactoryUtil.getInstance().openSession();
			Query query = session2.createQuery("from T_BorrowRecord order by BorrowNo");
			List result = query.list();
			/*
			 * for (int i = 0; i < result.size(); i++) { T_BorrowRecord b =
			 * (T_BorrowRecord) result.get(i); System.out.println(b); }
			 */
			session2.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			List result1 = new ArrayList<T_BorrowRecord>();
			return result1;
		}

	}

	/**
	 * 统计 按客户
	 * 
	 * @return
	 */
	public List<Map<String, Object>> cusSum() {
		Session session3 = SessionFactoryUtil.getInstance().openSession();
		Criteria criteria = session3.createCriteria(T_BorrowRecord.class);
		ProjectionList plist = Projections.projectionList();
		// 分组统计
		plist.add(Projections.sum("BorrowNumber"));
		plist.add(Projections.groupProperty("CustomerID"));
		// 将ProjectionList添加到Criteria对象中
		criteria.setProjection(plist);
		List<Object[]> p = criteria.list();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Object[] d : p) {
			Map<String, Object> item = new HashMap<>();
			// 把总数和客户名封装到T_Count
			T_Count c = new T_Count();
			c.setBorrowNumber((String) d[0]);
			c.setCustomerID((T_Customer) d[1]);
			// 存入map<客户名，T_Count类>
			item.put("cal", c);
			// 通过客户名找该用户的多条记录的详细信息
			String hql = "FROM T_BorrowRecord WHERE CustomerID = :cid ";
			List<T_BorrowRecord> result1 = session3.createQuery(hql).setParameter("cid", (T_Customer) d[1]).list();

			for (int i = 0; i < result1.size(); i++) {
				T_BorrowRecord b = (T_BorrowRecord) result1.get(i);
				System.out.println(b);
			}

			item.put("detail", result1);
			// 把一条记录信息的map：item存入list
			result.add(item);
		}
		session3.close();
		return result;

	}

	/**
	 * 统计 按样机
	 * 
	 * @return
	 */
	public List<Map<String, Object>> modleSum() {
		Session session2 = SessionFactoryUtil.getInstance().openSession();
		Criteria criteria = session2.createCriteria(T_BorrowRecord.class);
		ProjectionList plist = Projections.projectionList();
		// 分组统计
		plist.add(Projections.sum("BorrowNumber"));
		plist.add(Projections.groupProperty("ModelID"));
		// 将ProjectionList添加到Criteria对象中
		criteria.setProjection(plist);
		List<Object[]> p = criteria.list();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Object[] d : p) {
			Map<String, Object> item = new HashMap<>();
			// 把总数和客户名封装到T_Count
			T_Count c = new T_Count();
			c.setBorrowNumber((String) d[0]);
			c.setModelID((T_Model) d[1]);
			// 存入map<客户名，T_Count类>
			item.put("cal", c);
			// 通过客户名找该用户的多条记录的详细信息
			String hql = "FROM T_BorrowRecord WHERE ModelID = :cid ";
			List<T_BorrowRecord> result1 = session2.createQuery(hql).setParameter("cid", (T_Model) d[1]).list();
			item.put("detail", result1);
			// 把一条记录信息的map：item存入list
			result.add(item);
		}
		session2.close();
		return result;
	}

	/**
	 * 根据客户名称排序
	 * 
	 * @param
	 * @return
	 */
	public List<T_BorrowRecord> orderByCustomerID() {
		init();
		String hql = "FROM T_BorrowRecord order by CustomerID, ModelID, BorrowNumber";
		List<T_BorrowRecord> result = session.createQuery(hql).list();
		/*
		 * for (int i = 0; i < result.size(); i++) { T_BorrowRecord b =
		 * (T_BorrowRecord) result.get(i); }
		 */
		destory();
		return result;
	}

	/**
	 * 根据样机名称排序
	 * 
	 * @param
	 * @return
	 */
	public List<T_BorrowRecord> orderByModelID() {
		init();
		String hql = "FROM T_BorrowRecord order by ModelID,CustomerID,  BorrowNumber";
		List<T_BorrowRecord> result = session.createQuery(hql).list();
		/*
		 * for (int i = 0; i < result.size(); i++) { T_BorrowRecord b =
		 * (T_BorrowRecord) result.get(i); System.out.println(b); }
		 */
		destory();
		return result;
	}

	public Integer compare(T_BorrowRecord b1, T_BorrowRecord b2) {
		Integer id = b1.getBorrowNo().compareTo(b2.getBorrowNo());
		return id;
	}

	/**
	 * 根据客户名称、样机名称、借机时间、借机批准人、借条编号、归还日期等条件进行借机记录的查询
	 * 
	 * @return
	 */
	public List<T_BorrowRecord> findBorrowByCond(T_BorrowRecord b, String string) {
		init();
		DetachedCriteria dc = DetachedCriteria.forClass(T_BorrowRecord.class);
		if (b.getCustomerID() != null) {
			dc.add(Restrictions.eq("CustomerID", b.getCustomerID()));
		}
		if (b.getModelID() != null) {
			dc.add(Restrictions.eq("ModelID", b.getModelID()));
		}
		if (b.getBorrowOperatDatetime() != null) {
			dc.add(Restrictions.eq("BorrowOperatDatetime", b.getBorrowOperatDatetime()));
		}
		if (b.getBorrowPermitPerson() != null) {
			dc.add(Restrictions.eq("BorrowPermitPerson", b.getBorrowPermitPerson()));
		}
		if (b.getBorrowCheckNo() != null) {
			dc.add(Restrictions.eq("BorrowCheckNo", b.getBorrowCheckNo()));
		}
		if (b.getReturnDatetime() != null) {
			dc.add(Restrictions.eq("ReturnDatetime", b.getReturnDatetime()));
		}
		if ("yes".equals(string)) {
			dc.add(Restrictions.isNotNull("ReturnDatetime"));
		} else if ("no".equals(string)) {
			dc.add(Restrictions.isNull("ReturnDatetime"));
		}
		Criteria c = dc.getExecutableCriteria(session);
		List<T_BorrowRecord> result = c.list();
		/*
		 * for (int i = 0; i < result.size(); i++) { T_BorrowRecord b1 =
		 * (T_BorrowRecord) result.get(i); System.out.println(b1); }
		 */
		Collections.sort(result);
		destory();
		return result;
	}

}
