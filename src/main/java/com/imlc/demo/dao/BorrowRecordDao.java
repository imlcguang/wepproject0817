package com.imlc.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	public void deleteBorrowRecord(T_BorrowRecord b) {
		init();
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
	 * 统计
	 * @return
	 */
	public List<Object[]> cusSum() {
		init();
		Criteria criteria = session.createCriteria(T_BorrowRecord.class);
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.sum("BorrowNumber"));
		plist.add(Projections.groupProperty("CustomerID"));
		criteria.setProjection(plist);
		List<Object[]> p=criteria.list();
		for (Object[] d : p) {
			System.out.println(d[0]);
			System.out.println(d[1]);
			System.out.println("***************");
		}
		destory();
		return p;
		

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
		for (int i = 0; i < result.size(); i++) {
			T_BorrowRecord b = (T_BorrowRecord) result.get(i);
			System.out.println(b);
		}
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
		for (int i = 0; i < result.size(); i++) {
			T_BorrowRecord b = (T_BorrowRecord) result.get(i);
			System.out.println(b);
		}
		
		destory();
		return result;
	}
	
	/**
	 * 根据客户名称、样机名称、借机时间、借机批准人、借条编号、归还日期等条件进行借机记录的查询
	 * 
	 * @return
	 */
	public List<T_BorrowRecord> findBorrowByCond(T_BorrowRecord b,String string){
		init();
		DetachedCriteria dc = DetachedCriteria.forClass(T_BorrowRecord.class);
		if(b.getCustomerID()!=null){
			dc.add(Restrictions.eq("CustomerID", b.getCustomerID()));
		}
		if(b.getModelID()!=null){
			dc.add(Restrictions.eq("ModelID", b.getModelID()));
		}
		if(b.getBorrowOperatDatetime()!=null){
			dc.add(Restrictions.eq("BorrowOperatDatetime", b.getBorrowOperatDatetime()));
		}
		if(b.getBorrowPermitPerson()!=null){
			dc.add(Restrictions.eq("BorrowPermitPerson", b.getBorrowPermitPerson()));
		}
		if(b.getBorrowCheckNo()!=null){
			dc.add(Restrictions.eq("BorrowCheckNo", b.getBorrowCheckNo()));
		}
		if(b.getReturnDatetime()!=null){
			dc.add(Restrictions.eq("ReturnDatetime", b.getReturnDatetime()));
		}
		if("yes".equals(string)){
			dc.add(Restrictions.isNotNull("ReturnDatetime"));
		}
		else if ("no".equals(string)) {
			dc.add(Restrictions.isNull("ReturnDatetime"));
		}
		Criteria c = dc.getExecutableCriteria(session);
	       List<T_BorrowRecord> result = c.list();
		for (int i = 0; i < result.size(); i++) {
			T_BorrowRecord b1 = (T_BorrowRecord) result.get(i);
			System.out.println(b1);
		}
		destory();
		return result;
	}
	
}
