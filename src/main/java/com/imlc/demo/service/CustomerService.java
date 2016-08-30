package com.imlc.demo.service;

import java.util.List;

import javax.enterprise.inject.New;

import com.imlc.demo.dao.CustomerDao;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.exception.MsgException;

public class CustomerService {
	private CustomerDao dao = new CustomerDao();

	/**
	 * 添加客户
	 * 
	 * @param
	 * @throws MsgException
	 */
	public void registCustomer(T_Customer customer) throws MsgException {
		// 检查用户名是否存在，存在则提示
		if (dao.findCustomerName(customer.getCustomerName()) != null) {
			throw new MsgException("客户名已经存在");
		}
		// 如果不存在，调用dao方法添加用户
		dao.AddCustomer(customer);
	}

	/**
	 * 查询所有的顾客信息
	 * 
	 * @return
	 */
	public List<T_Customer> findAllCus() {
		return dao.findAllCus();
	}

	/**
	 * 通过ID查询客户
	 * 
	 * @param id
	 * @return
	 */
	public T_Customer findCustById(Integer id) {
		return dao.findByCustomerID(id);
	}

	/**
	 * 修改客户信息
	 * 
	 * @param customer
	 */
	public void updateCustomers(T_Customer customer) {
		dao.updateCustomers(customer);
	}

	/**
	 * 删除客户信息
	 * 
	 * @param customer
	 */
	public void DeleteCustomers(T_Customer customer) {
		dao.deleteCustomers(customer);
	}

	/**
	 * 通过客户姓名、联系人、联系电话模糊查询
	 * 
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public List<T_Customer> findCustByCond(T_Customer customer) throws Exception {
		return dao.findCustByCond(customer);

	}

}
