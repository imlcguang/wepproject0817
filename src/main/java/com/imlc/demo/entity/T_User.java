package com.imlc.demo.entity;

import java.io.Serializable;

import com.imlc.demo.exception.MsgException;
//实现接口
public class T_User implements Serializable{
	private Integer UserID;
	private String LoginName;
	private String Password;
	//Password2确认密码
	private String Password2;
	private String UserName;
	private String UserSex;
	private String FunctionPopedom;
	//private String FunctionPopedom;

	public T_User() {
	}

	public String getPassword2() {
		return Password2;
	}

	public void setPassword2(String password2) {
		Password2 = password2;
	}

	public T_User(Integer userID, String loginName, String password, String userName, String userSex,
			String functionPopedom) {
		// super();
		UserID = userID;
		LoginName = loginName;
		Password = password;
		UserName = userName;
		UserSex = userSex;
		FunctionPopedom = functionPopedom;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserSex() {
		return UserSex;
	}

	public void setUserSex(String userSex) {
		UserSex = userSex;
	}

	public String getFunctionPopedom() {
		return FunctionPopedom;
	}

	public void setFunctionPopedom(String functionPopedom2) {
		FunctionPopedom = functionPopedom2;
	}

	@Override
	public String toString() {
		return "T_User [UserID=" + UserID + ", LoginName=" + LoginName + ", Password=" + Password + ", UserName="
				+ UserName + ", UserSex=" + UserSex + ", FunctionPopedom=" + FunctionPopedom + "]";
	}
	public void checkValue() throws MsgException{
		if(LoginName==null || "".equals(LoginName)){
			throw new MsgException("登录名不能为空!");
		}
		if(Password==null || "".equals(Password)){
			throw new MsgException("密码不能为空!");
		}
		if(Password2==null || "".equals(Password2)){
			throw new MsgException("确认密码不能为空!");
		}
		if(!Password.equals(Password2)){
			throw new MsgException("两次密码不一致!");
		}
		
		if(UserName==null || "".equals(UserName)){
			throw new MsgException("用户名不能为空!");
		}
		if(UserSex==null || "".equals(UserSex)){
			throw new MsgException("性别不能为空!");
		}
		if(FunctionPopedom==null || "".equals(FunctionPopedom)){
			throw new MsgException("权限不能为空!");
		}
		
		/*if(!email.matches("^\\w+@\\w+(\\.\\w+)+$")){
			throw new MsgException("邮箱格式不正确!");
		}*/
	}
}
