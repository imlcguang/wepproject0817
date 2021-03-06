package com.imlc.demo.service;

import java.util.List;

import com.imlc.demo.dao.BorrowRecordDao;
import com.imlc.demo.dao.HibernateRecordDao;
import com.imlc.demo.entity.T_BorrowRecord;

public class HibernateRecordService {
	
	
	private static HibernateRecordService HibernateRecordService=null;

	public static HibernateRecordService getInstance(){
		if(HibernateRecordService == null){
			HibernateRecordService = new HibernateRecordService();
		}
		return HibernateRecordService;
	}

	private HibernateRecordService(){
		
	}
	
	private HibernateRecordDao dao = new HibernateRecordDao();
	private BorrowRecordDao daob = new BorrowRecordDao();

	public   List<T_BorrowRecord> findRecord(int pageIndex,int pageSize) {
		daob.countrecord();
		return dao.findRecord(pageIndex,pageSize);
	}

}
