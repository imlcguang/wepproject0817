package com.imlc.demo.service;

import java.util.List;

import com.imlc.demo.dao.HibernateRecordDao;
import com.imlc.demo.entity.Pager;
import com.imlc.demo.entity.T_BorrowRecord;

public class HibernateRecordService {
	private static HibernateRecordDao recordDao;
	
	public HibernateRecordService(){
		recordDao = new HibernateRecordDao();
	}
	public static List<T_BorrowRecord> findRecord(int pageIndex,int pageSize) {
		List<T_BorrowRecord> recordResult = recordDao.findRecord(pageIndex,pageSize);
		return recordResult;
	}

}
