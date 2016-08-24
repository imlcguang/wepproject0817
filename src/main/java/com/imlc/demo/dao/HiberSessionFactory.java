package com.imlc.demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberSessionFactory {
	
	private static SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Configuration config;
	   static{
		    // 创建配置对象
			config = new Configuration().configure();
			//"src/main/resources/Hibernate.cfg.xml"
			
			// 创建会话工程对象
			// sessionFactory = config.buildSessionFactory(serviceRegistry);
			sessionFactory = config.buildSessionFactory();
	   }
	   public static SessionFactory getSessionFactory(){
	      return sessionFactory;
	   }
}