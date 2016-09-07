package com.imlc.demo.test;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_Count;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.hibernate.SessionFactoryUtil;



public class Test {
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


	public static void main(String[] args)  {
		init();
		Criteria criteria = session.createCriteria(T_BorrowRecord.class);
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.sum("BorrowNumber"));
		plist.add(Projections.groupProperty("CustomerID"));
		criteria.setProjection(plist);
		List<Object[]> p=criteria.list();
		List<T_Count> result=new ArrayList<T_Count>();
		for (Object[] d : p) {
			T_Count c=new T_Count();
			c.setBorrowNumber((String)d[0]);
			System.out.println("BorrowNumber:    "+c.getBorrowNumber());
			c.setCustomerID((T_Customer)d[1]);
			System.out.println("Customer:   "+c.getCustomerID());
		    result.add(c);
			System.out.println("***************");
		}
		
		
		
		
		destory();
		
	}
		

}
