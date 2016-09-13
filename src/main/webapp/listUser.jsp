<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body style="text-align: center;">
	<h1>用户列表页面</h1>
	<hr>
	<font color="red">${msg }</font>
	<form
		action="${pageContext.request.contextPath }/FindUserByNameServlet"
		method="POST">
		<select name="getid"  >
		<option value="">请选择用户姓名</option>
			<c:forEach items="${requestScope.list}" var="user" >
				<option value="${user.userName }">${user.userName }</option>
			</c:forEach>
		</select> 
		<input type="submit" value="条件查询用户" />
	</form>

	<p>权限备注：1（有权限），0（无权限）。功能按顺序分别为用户信息管理、借机统计、借机明细查询、样机信息维护、客户信息维护、样机归还、借机登记</p>
	<table border="1" width="100%" >
		<tr>
			<th>用户 ID</th>
			<th>登录名</th>
			<th>用户姓名</th>
			<th>用户性别</th>
			<th>权限</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="user">
			<tr>
				<td> <c:out value="${user.userID }" /></td>
				<td><c:out value="${user.loginName }" /></td>
				<td><c:out value="${user.userName }" /></td>
				<td><c:out value="${user.userSex }" /></td>
				<td><c:out value="${user.functionPopedom }" /></td>

				<td><a
					href="${pageContext.request.contextPath }/UserInfoServlet?id=${user.userID }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DelUserServlet?id=${user.userID }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href=index.jsp>返回主页</a>
</body>
</html>