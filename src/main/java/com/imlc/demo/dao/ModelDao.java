package com.imlc.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.imlc.demo.entity.T_Model;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.hibernate.SessionFactoryUtil;

public class ModelDao {
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
			 int total = ((Long)this.session.createQuery("select count(id) from T_Model ").uniqueResult()).intValue();
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
	public List<T_Model> findAllModel(int pageIndex, int pageSize) {
		Session session2 = SessionFactoryUtil.getInstance().openSession();
		// 获取query对象
		String hql = "from T_Model order by ModelID";
		Query hqlQuery = session2.createQuery(hql);

		// 从第几条记录开始查询
		hqlQuery.setFirstResult((pageIndex - 1) * pageSize);

		// 一共查询多少条记录
		hqlQuery.setMaxResults(pageSize);

		// 获取查询的结果
		List<T_Model> result = hqlQuery.list();
		session2.close();
		return result;
	}
	
	/**
	 * 添加样机
	 * 
	 * @param c
	 *           
	 */

	public void AddModel(T_Model c) {
		init();
		session.save(c);
		System.out.println("新增成功！您的ID为：" + c.getModelID());
		destory();
	}

	/**
	 * 修改样机信息
	 * 
	 * @param id
	 */
	public void updateModels(T_Model c) {
		init();
		session.update(c);
		destory();
	}

	/**
	 * 删除 根据ID删除
	 */
	public void deleteModels(T_Model c) {
		init();
		session.delete(c);
		destory();
	}

	/**
	 * 根据ID查找样机
	 * 
	 * @param modelID
	 *            
	 * @return 根据样机名找到样机信息，如果没找到返回null
	 */
	public T_Model findByModelID(Integer ModelID) {
		init();
		T_Model model = (T_Model) session.get(T_Model.class, ModelID);
		destory();
		return model;
	}

	/**
	 * 根据样机名查找样机是否存在
	 * 
	 * @param modelName
	 *            样机名
	 * @return 根据样机名找到样机信息，如果没找到返回null
	 */
	public T_Model findModelName(String modelName) {
		init();
		String hql = "FROM T_Model WHERE modelName = :mdn ";
		List<T_Model> result = session.createQuery(hql).setParameter("mdn", modelName).list();

		T_Model model = null; // (User)list;
		for (T_Model model2 : result)
			model = model2;
		destory();
		return model;
	}

	/**
	 * 模糊查询样机名称模糊查询
	 * 
	 * @param sname
	 * @return
	 * @throws Exception
	 */
	public static List<T_Model> findByModelName(String modelName) throws Exception {
		init();
		String hql = "FROM T_Model WHERE modelName like :mdn ";
		List<T_Model> result = session.createQuery(hql).setParameter("mdn", "%" + modelName + "%").list();
		destory();
		return result;
	}

	/**
	 * 查询所有的信息
	 * 
	 * @return
	 */
	public List<T_Model> findAllModel() {
		Session  session2= SessionFactoryUtil.getInstance().openSession();
		Query query = session2.createQuery("from T_Model ");
		List result = query.list();
		session2.close();
		return result;

	}
}
