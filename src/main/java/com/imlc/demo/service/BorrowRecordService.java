package com.imlc.demo.service;

import java.util.List;
import java.util.Map;

import com.imlc.demo.dao.BorrowRecordDao;
import com.imlc.demo.dao.CustomerDao;
import com.imlc.demo.dao.ModelDao;
import com.imlc.demo.dao.UserDao;
import com.imlc.demo.entity.T_BorrowRecord;
import com.imlc.demo.entity.T_Customer;
import com.imlc.demo.entity.T_Model;
import com.imlc.demo.entity.T_User;
import com.imlc.demo.exception.MsgException;

public class BorrowRecordService {
	
	
private static BorrowRecordService borrowRecordService=null;

public static BorrowRecordService getInstance(){
	if(borrowRecordService == null){
		borrowRecordService = new BorrowRecordService();
	}
	return borrowRecordService;
}

private BorrowRecordService(){
	
}
BorrowRecordDao daob  = new BorrowRecordDao();
ModelDao daom=new ModelDao();
CustomerDao daoc=new CustomerDao();
UserDao daou=new UserDao();
	/**
	 * 添加，借机登记
	 * @param m
	 */
	public void borrowRecord(T_BorrowRecord b) {
		daob.borrowRecord(b);
	}
	
	/**
	 * 根据借机ID查找借机表
	 * 
	 * @param id
	 * @return
	 */
	public T_BorrowRecord findBorrowByID(String id) {
		return daob.findBorrowByID(id);
	}
	
	
	/**
	 * 归还样机
	 * @param id
	 */
	public void returnRecord(T_BorrowRecord b) {
	    daob.returnRecord(b);
	}
	
	
	

	/**
	 * 修改更新
	 * @param id
	 */
	public void updateBorrowRecord(T_BorrowRecord b) {
		daob.updateBorrowRecord(b);
	}

	/**
	 *  删除
	 * @param id
	 */
	public void deleteBorrowRecord(T_BorrowRecord b) {
		daob.deleteBorrowRecord(b);
	}

	
	/**
	 * 查询所有的信息
	 * 
	 * @return
	 */
	public List<T_BorrowRecord> findAllBorrow() {
		return daob.findAllBorrow();

	}
	
	/**
	 * 查询所有信息分页显示
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public   List<T_BorrowRecord> findRecord(int pageIndex,int pageSize) {
		return daob.findRecord(pageIndex,pageSize);
	}
	
	/**
	 * 查询所有记录总数
	 */
	public int  countrecord() {
		return daob.countrecord();
	}
	
	
	/**
	 * 统计，按客户
	 * @return
	 */
	public List<Map<String, Object>> cusSum(String string) {
		if("Cus".equals(string)){
		return daob.cusSum();
		}
		else {
			return daob.modleSum();
		}
	}
	/**
	 * 排序
	 * @param string
	 * @return
	 */
	public List<T_BorrowRecord> order(String string){
		if("Cus".equals(string)){
			return daob.orderByCustomerID();
		}
		else {
			return daob.orderByModelID();
		}
	}

	/**
	 * 通过ID查询用户
	 * 
	 * @param id
	 * @return
	 */
	public T_User findUserById(String id) throws MsgException{
		Integer i=Integer.parseInt(id);
		if( daou.findUserByID(i)==null){
			throw new MsgException("找不到批准人或操作员！");
		}
		else {
			return daou.findUserByID(i);
		}
	}
	/**
	 * 通过ID查询客户是否存在
	 * 
	 * @param id
	 * @return
	 */
	public T_Customer findCustById(String id) throws MsgException {
		Integer i=Integer.parseInt(id);
		if( daoc.findByCustomerID(i)==null){
			throw new MsgException("找不到客户！");
		}
		else {
			return daoc.findByCustomerID(i);
		}
		 
	}
	
	
	/**
	 * 通过ID查询样机是否存在
	 * 
	 * @param id
	 * @return
	 */
	public  T_Model findModelById(String id) throws MsgException{
		Integer i=Integer.parseInt(id);
		if( daom.findByModelID(i)==null){
			throw new MsgException("找不到样机！");
		}
		else {
			return daom.findByModelID(i);
		}
	}
	
	public List<T_BorrowRecord> findBorrowByCond(T_BorrowRecord borrowRecord,String string) {
			return daob.findBorrowByCond(borrowRecord,string);
	}
	
	
}
