<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<h1>用户登录</h1><hr>
<font color="red">${msg}</font>
<form name="form1" method="post" action="<%=request.getContextPath()%>/UserLogin" onSubmit="return check()">
   登录帐号：<input type="text" id="loginName" name="loginName"><br>
   登录密码：<input type="password" id="userPWD" name="userPWD"><br>
  <input type="submit" name="submit" value="提交">
</form>
<a href=index.jsp>返回主页</a>
</body>
</html>