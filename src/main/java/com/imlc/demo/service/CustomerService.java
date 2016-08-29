package com.imlc.demo.service;

import java.util.List;

import javax.enterprise.inject.New;

import com.imlc.demo.dao.CustomerDao;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.exception.MsgException;

public class CustomerService {
	private CustomerDao dao =  new CustomerDao();
	/**
	 * 添加客户
	 * @param 
	 * @throws MsgException 
	 */
		public void registCustomer(T_Customer customer) throws MsgException{
			//检查用户名是否存在，存在则提示
			if(dao.findUserByCustomerName(customer.getCustomerName())!=null){
				throw new MsgException("客户名已经存在");
			}
			//如果不存在，调用dao方法添加用户
			dao.AddCustomer(customer);
		}
		
		/**
		 * 查询所有的顾客信息
		 * @return 
		 */
		public  List<T_Customer> findAllCus(){
			return dao.findAllCus();
		}
		
		
}
