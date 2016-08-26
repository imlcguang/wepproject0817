package test;

import java.io.Serializable;
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
}
