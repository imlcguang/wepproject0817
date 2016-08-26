package com.imlc.demo.test;

import org.junit.Test;

import com.imlc.demo.dao.UserDao;
import com.imlc.demo.entity.T_User;

public class UserDaoTest {
  @Test
  public void testfindUserByLoginName(){
	  UserDao dao=new UserDao();
	 T_User user=dao.findUserByLoginName("qwe");
	 System.out.println(user);
	  
  }

}
