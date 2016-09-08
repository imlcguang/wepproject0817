package com.imlc.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

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

	public static void main(String[] args) {
		init();
		Criteria criteria = session.createCriteria(T_BorrowRecord.class);
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
			// System.out.println("BorrowNumber: "+c.getBorrowNumber());
			c.setCustomerID((T_Customer) d[1]);
			// System.out.println("Customer: "+c.getCustomerID());
			// 存入map<客户名，T_Count类>
			item.put("cal", c);
			// 通过客户名找该用户的多条记录的详细信息
			String hql = "FROM T_BorrowRecord WHERE CustomerID = :cid ";
			List<T_BorrowRecord> result1 = session.createQuery(hql).setParameter("cid", (T_Customer) d[1]).list();
			for (int i = 0; i < result1.size(); i++) {
				T_BorrowRecord b = (T_BorrowRecord) result1.get(i);
				System.out.println("detail组合"+b);
			}
			item.put("detail", result1);
			// 把一条记录信息的map：item存入list
			result.add(item);
		}
         System.out.println("这是map中的 ");
		for (int i = 0; i < result.size(); i++) {
			Map<String, Object> map = result.get(i);
			Set set = map.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				System.out.println(map.get(it.next()));
			}
			System.out.println("_____________________________");
		}
		destory();

	}

}
